package com.stradar.strava.api;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.micronaut.core.annotation.Introspected;

@Introspected
@JsonNaming(SnakeCaseStrategy.class)
public class Athlete {

    private String username;

    public Athlete(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
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