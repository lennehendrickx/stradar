package com.stradar.strava.api;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;

import static io.micronaut.http.HttpHeaders.AUTHORIZATION;

@Header(name = "User-Agent", value = "Micronaut")
@Client("https://www.strava.com/api/v3")
public interface AthleteClient {

    @Get("/athlete")
    Single<Athlete> currentAthlete(@Header(AUTHORIZATION) BearerToken bearerToken);
}