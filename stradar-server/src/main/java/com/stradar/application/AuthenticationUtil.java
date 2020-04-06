package com.stradar.application;

import com.stradar.strava.api.BearerToken;
import io.micronaut.security.authentication.Authentication;

import static com.stradar.strava.api.BearerToken.bearerToken;
import static io.micronaut.security.oauth2.endpoint.token.response.OauthUserDetailsMapper.ACCESS_TOKEN_KEY;

public class AuthenticationUtil {

    public static BearerToken toBearerToken(Authentication authentication) {
        return bearerToken(getAccessToken(authentication));
    }

    private static String getAccessToken(Authentication authentication) {
        return authentication
                .getAttributes()
                .get(ACCESS_TOKEN_KEY)
                .toString();
    }

}
