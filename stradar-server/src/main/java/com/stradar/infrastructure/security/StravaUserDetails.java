package com.stradar.infrastructure.security;

import static io.micronaut.security.oauth2.endpoint.token.response.OauthUserDetailsMapper.ACCESS_TOKEN_KEY;
import static io.micronaut.security.oauth2.endpoint.token.response.OauthUserDetailsMapper.REFRESH_TOKEN_KEY;
import static java.util.Collections.singletonList;
import static java.util.Map.entry;

import com.stradar.application.User;
import io.micronaut.security.authentication.UserDetails;
import java.util.Map;

public class StravaUserDetails extends UserDetails implements User {

  public static final String ROLE_STRAVA_ATHLETE = "ROLE_STRAVA_ATHLETE";
  public static final String USERNAME = "username";
  public static final String FIRSTNAME = "firstname";
  public static final String LASTNAME = "lastname";
  public static final String CITY = "city";
  public static final String COUNTRY = "country";
  public static final String SEX = "sex";
  public static final String FRIEND_COUNT = "friend_count";
  public static final String FOLLOWER_COUNT = "follower_count";
  public static final String PROFILE = "profile";
  public static final String WEIGHT = "weight";

  private final Map<String, Object> attributes;

  public static StravaUserDetails stravaUserDetails(
      String accessToken,
      String refreshToken,
      String username,
      String firstname,
      String lastname,
      String city,
      String country,
      String sex,
      int friendCount,
      int followerCount,
      String profile,
      double weight) {
    return new StravaUserDetails(
        Map.ofEntries(
            entry(ACCESS_TOKEN_KEY, accessToken),
            entry(REFRESH_TOKEN_KEY, refreshToken),
            entry(USERNAME, username),
            entry(FIRSTNAME, firstname),
            entry(LASTNAME, lastname),
            entry(CITY, city),
            entry(COUNTRY, country),
            entry(SEX, sex),
            entry(FRIEND_COUNT, friendCount),
            entry(FOLLOWER_COUNT, followerCount),
            entry(PROFILE, profile),
            entry(WEIGHT, weight)));
  }

  private StravaUserDetails(Map<String, Object> attributes) {
    super((String) attributes.get(USERNAME), singletonList(ROLE_STRAVA_ATHLETE), attributes);
    this.attributes = attributes;
  }

  public String getAccessToken() {
    return (String) attributes.get(ACCESS_TOKEN_KEY);
  }

  public String getRefreshToken() {
    return (String) attributes.get(REFRESH_TOKEN_KEY);
  }

  public String getFirstname() {
    return (String) attributes.get(FIRSTNAME);
  }

  public String getLastname() {
    return (String) attributes.get(LASTNAME);
  }

  public String getCity() {
    return (String) attributes.get(CITY);
  }

  public String getCountry() {
    return (String) attributes.get(COUNTRY);
  }

  public String getSex() {
    return (String) attributes.get(SEX);
  }

  public int getFriendCount() {
    return (int) attributes.get(FRIEND_COUNT);
  }

  public int getFollowerCount() {
    return (int) attributes.get(FOLLOWER_COUNT);
  }

  public String getProfile() {
    return (String) attributes.get(PROFILE);
  }

  public double getWeight() {
    return (double) attributes.get(WEIGHT);
  }
}
