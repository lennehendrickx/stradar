package com.stradar.application;

import io.micronaut.core.annotation.Introspected;

@Introspected
public interface User {

  String getAccessToken();

  String getRefreshToken();

  String getUsername();

  String getFirstname();

  String getLastname();

  String getCity();

  String getCountry();

  String getSex();

  int getFriendCount();

  int getFollowerCount();

  String getProfile();

  double getWeight();
}
