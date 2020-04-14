package com.stradar.strava.api.athlete;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.micronaut.core.annotation.Introspected;

@Introspected
@JsonNaming(SnakeCaseStrategy.class)
public class Athlete {

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

  public Athlete(
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

/*
Example JSON
{
    "id": 2153161,
    "username": "lhendrickx",
    "resource_state": 3,
    "firstname": "Lenne",
    "lastname": "Hendrickx",
    "city": "Rotselaar",
    "state": "Flanders",
    "country": "Belgium",
    "sex": "M",
    "premium": false,
    "summit": false,
    "created_at": "2013-05-13T15:06:46Z",
    "updated_at": "2020-02-08T22:14:02Z",
    "badge_type_id": 0,
    "profile_medium": "https://graph.facebook.com/512583373/picture?height=256&width=256",
    "profile": "https://graph.facebook.com/512583373/picture?height=256&width=256",
    "friend": null,
    "follower": null,
    "follower_count": 84,
    "friend_count": 84,
    "mutual_friend_count": 0,
    "athlete_type": 1,
    "date_preference": "%m/%d/%Y",
    "measurement_preference": "meters",
    "clubs": [
        {
            "id": 156527,
            "resource_state": 2,
            "name": "F3 - HST Pendelaars Leuven - Zaventem",
            "profile_medium": "https://dgalywyr863hv.cloudfront.net/pictures/clubs/156527/3869804/1/medium.jpg",
            "profile": "https://dgalywyr863hv.cloudfront.net/pictures/clubs/156527/3869804/1/large.jpg",
            "cover_photo": "https://dgalywyr863hv.cloudfront.net/pictures/clubs/156527/4530713/2/large.jpg",
            "cover_photo_small": "https://dgalywyr863hv.cloudfront.net/pictures/clubs/156527/4530713/2/small.jpg",
            "sport_type": "cycling",
            "city": "Herent",
            "state": "Vlaanderen",
            "country": "België",
            "private": false,
            "member_count": 0,
            "featured": false,
            "verified": false,
            "url": "HSTers",
            "membership": "member",
            "admin": false,
            "owner": false
        }
    ],
    "ftp": null,
    "weight": 89.0,
    "bikes": [],
    "shoes": []
}
 */
