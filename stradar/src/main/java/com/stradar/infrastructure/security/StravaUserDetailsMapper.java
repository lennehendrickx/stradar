package com.stradar.infrastructure.security;

import com.stradar.strava.api.StravaApiClient;
import io.micronaut.security.authentication.UserDetails;
import io.micronaut.security.oauth2.endpoint.token.response.OauthUserDetailsMapper;
import io.micronaut.security.oauth2.endpoint.token.response.TokenResponse;
import org.reactivestreams.Publisher;

import javax.inject.Named;
import javax.inject.Singleton;

import static io.micronaut.http.HttpHeaderValues.AUTHORIZATION_PREFIX_BEARER;
import static java.util.Collections.singletonList;
import static java.util.Collections.singletonMap;

@Named("strava")
@Singleton
class StravaUserDetailsMapper implements OauthUserDetailsMapper {

    private final StravaApiClient apiClient;

    StravaUserDetailsMapper(StravaApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public Publisher<UserDetails> createUserDetails(TokenResponse tokenResponse) {
        return apiClient.getAthlete(AUTHORIZATION_PREFIX_BEARER + " " + tokenResponse.getAccessToken())
                .map(athlete -> new UserDetails(
                        athlete.getUsername(),
                        singletonList("ROLE_STRAVA"),
                        singletonMap(
                                ACCESS_TOKEN_KEY,
                                tokenResponse.getAccessToken()))).toFlowable();
    }
}