package com.stradar.infrastructure.security;

import static com.stradar.infrastructure.security.StravaUserDetails.stravaUserDetails;
import static com.stradar.strava.api.BearerToken.bearerToken;

import com.stradar.strava.api.StravaApiClient;
import com.stradar.strava.api.athlete.Athlete;
import io.micronaut.security.authentication.UserDetails;
import io.micronaut.security.oauth2.endpoint.token.response.OauthUserDetailsMapper;
import io.micronaut.security.oauth2.endpoint.token.response.TokenResponse;
import javax.inject.Named;
import javax.inject.Singleton;
import org.reactivestreams.Publisher;

@Named("strava")
@Singleton
class StravaUserDetailsMapper implements OauthUserDetailsMapper {

  private final StravaApiClient apiClient;

  StravaUserDetailsMapper(StravaApiClient apiClient) {
    this.apiClient = apiClient;
  }

  @Override
  public Publisher<UserDetails> createUserDetails(TokenResponse tokenResponse) {
    var bearerToken = bearerToken(tokenResponse.getAccessToken());
    return apiClient
        .athlete()
        .currentAthlete(bearerToken)
        .map(athlete -> toUserDetails(tokenResponse, athlete))
        .toFlowable();
  }

  private static UserDetails toUserDetails(TokenResponse tokenResponse, Athlete athlete) {
    return stravaUserDetails(
        tokenResponse.getAccessToken(),
        tokenResponse.getRefreshToken(),
        athlete.getUsername(),
        athlete.getFirstname(),
        athlete.getLastname(),
        athlete.getCity(),
        athlete.getCountry(),
        athlete.getSex(),
        athlete.getFriendCount(),
        athlete.getFollowerCount(),
        athlete.getProfile(),
        athlete.getWeight());
  }
}
