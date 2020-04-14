package com.stradar.strava.api.athlete;

import static io.micronaut.http.HttpHeaders.AUTHORIZATION;

import com.stradar.strava.api.BearerToken;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Client("https://www.strava.com/api/v3")
public interface AthleteClient {

  @Get("/athlete")
  Single<Athlete> currentAthlete(@Header(AUTHORIZATION) BearerToken bearerToken);

  @Get("/athlete/activities")
  Flowable<Activity> activities(@Header(AUTHORIZATION) BearerToken bearerToken);
}
