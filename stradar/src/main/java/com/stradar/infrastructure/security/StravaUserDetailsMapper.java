package com.stradar.infrastructure.security;

import com.stradar.strava.api.StravaApiClient;
import com.stradar.strava.api.athlete.Athlete;
import io.micronaut.security.authentication.UserDetails;
import io.micronaut.security.oauth2.endpoint.token.response.OauthUserDetailsMapper;
import io.micronaut.security.oauth2.endpoint.token.response.TokenResponse;
import org.reactivestreams.Publisher;

import javax.inject.Named;
import javax.inject.Singleton;

import static com.stradar.strava.api.BearerToken.bearerToken;

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
        return new StravaUserDetails(
                athlete.getUsername(),
                tokenResponse.getAccessToken(),
                tokenResponse.getRefreshToken());
    }
}