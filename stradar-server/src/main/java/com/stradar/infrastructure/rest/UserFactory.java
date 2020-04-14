package com.stradar.infrastructure.rest;

import static com.stradar.infrastructure.security.StravaUserDetails.*;
import static io.micronaut.security.oauth2.endpoint.token.response.OauthUserDetailsMapper.ACCESS_TOKEN_KEY;
import static io.micronaut.security.oauth2.endpoint.token.response.OauthUserDetailsMapper.REFRESH_TOKEN_KEY;

import com.stradar.application.User;
import io.micronaut.security.authentication.Authentication;

public class UserFactory {

  public static User toUser(Authentication authentication) {
    var attributes = authentication.getAttributes();
    return stravaUserDetails(
        (String) attributes.get(ACCESS_TOKEN_KEY),
        (String) attributes.get(REFRESH_TOKEN_KEY),
        (String) attributes.get(USERNAME),
        (String) attributes.get(FIRSTNAME),
        (String) attributes.get(LASTNAME),
        (String) attributes.get(CITY),
        (String) attributes.get(COUNTRY),
        (String) attributes.get(SEX),
        ((Long) attributes.get(FRIEND_COUNT)).intValue(),
        ((Long) attributes.get(FOLLOWER_COUNT)).intValue(),
        (String) attributes.get(PROFILE),
        (Double) attributes.get(WEIGHT));
  }
}
