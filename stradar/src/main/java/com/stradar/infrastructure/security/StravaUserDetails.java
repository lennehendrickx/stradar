package com.stradar.infrastructure.security;

import io.micronaut.security.authentication.UserDetails;

import static io.micronaut.security.oauth2.endpoint.token.response.OauthUserDetailsMapper.ACCESS_TOKEN_KEY;
import static java.util.Collections.singletonList;
import static java.util.Collections.singletonMap;

public class StravaUserDetails extends UserDetails {


    private static final String ROLE_STRAVA_ATHLETE = "ROLE_STRAVA_ATHLETE";

    public StravaUserDetails(String username, String accessToken) {
        super(
                username,
                singletonList(ROLE_STRAVA_ATHLETE),
                singletonMap(ACCESS_TOKEN_KEY, accessToken));
    }
}
