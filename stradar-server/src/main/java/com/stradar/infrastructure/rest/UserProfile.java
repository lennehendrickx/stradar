package com.stradar.infrastructure.rest;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class UserProfile {

  private final String username;
  private final String firstname;
  private final String lastname;
  private final String city;
  private final String country;
  private final String sex;
  private final int friendCount;
  private final int followerCount;
  private final String profile;
  private final double weight;

  public UserProfile(
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
    this.username = username;
    this.firstname = firstname;
    this.lastname = lastname;
    this.city = city;
    this.country = country;
    this.sex = sex;
    this.friendCount = friendCount;
    this.followerCount = followerCount;
    this.profile = profile;
    this.weight = weight;
  }

  public String getUsername() {
    return username;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getCity() {
    return city;
  }

  public String getCountry() {
    return country;
  }

  public String getSex() {
    return sex;
  }

  public int getFriendCount() {
    return friendCount;
  }

  public int getFollowerCount() {
    return followerCount;
  }

  public String getProfile() {
    return profile;
  }

  public double getWeight() {
    return weight;
  }
}
