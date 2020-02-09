package com.stradar.infrastructure.rest;

import com.stradar.application.PhotoService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.views.View;

import java.util.Map;

import static io.micronaut.http.HttpHeaderValues.AUTHORIZATION_PREFIX_BEARER;
import static io.micronaut.security.oauth2.endpoint.token.response.OauthUserDetailsMapper.ACCESS_TOKEN_KEY;
import static io.micronaut.security.rules.SecurityRule.IS_AUTHENTICATED;
import static java.util.Map.entry;

@Controller("/photos")
public class PhotoController {

    private final PhotoService conferenceService;

    public PhotoController(PhotoService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @Secured(IS_AUTHENTICATED)
    @View("photos")
    @Get
    public Map<String, Object> photos(Authentication authentication) {
        // TODO: Make call to fetch actual photos
        var bearerToken = bearerToken(authentication);
        System.out.println("Bearer token" + bearerToken);
        return Map.ofEntries(
                entry("photos", conferenceService.randomPhoto()));
    }

    private String bearerToken(Authentication authentication) {
        String authorization = null;
        Object claim = authentication.getAttributes().get(ACCESS_TOKEN_KEY);
        if (claim instanceof String) {
            authorization = AUTHORIZATION_PREFIX_BEARER + " " + claim.toString();
        }
        return authorization;
    }
}