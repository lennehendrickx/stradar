package com.stradar.strava.api;

import static io.micronaut.http.HttpHeaderValues.AUTHORIZATION_PREFIX_BEARER;

public class BearerToken {

  private final String accessToken;

  private BearerToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public static BearerToken bearerToken(String accessToken) {
    return new BearerToken(accessToken);
  }

  @Override
  public String toString() {
    return AUTHORIZATION_PREFIX_BEARER + " " + accessToken;
  }
}
