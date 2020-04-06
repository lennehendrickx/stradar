package com.stradar.infrastructure.security;

import io.micronaut.security.authentication.UserDetails;

import java.util.Map;

import static io.micronaut.security.oauth2.endpoint.token.response.OauthUserDetailsMapper.ACCESS_TOKEN_KEY;
import static io.micronaut.security.oauth2.endpoint.token.response.OauthUserDetailsMapper.REFRESH_TOKEN_KEY;
import static java.util.Collections.singletonList;
import static java.util.Map.entry;

public class StravaUserDetails extends UserDetails {

    private static final String ROLE_STRAVA_ATHLETE = "ROLE_STRAVA_ATHLETE";

    public StravaUserDetails(String username, String accessToken, String refreshToken) {
        super(
                username,
                singletonList(ROLE_STRAVA_ATHLETE),
                Map.ofEntries(
                        entry(ACCESS_TOKEN_KEY, accessToken),
                        entry(REFRESH_TOKEN_KEY, refreshToken)));
    }
}
