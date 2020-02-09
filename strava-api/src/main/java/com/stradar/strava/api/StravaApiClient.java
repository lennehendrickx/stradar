package com.stradar.strava.api;

import javax.inject.Singleton;

@Singleton
public class StravaApiClient {

    private final AthleteClient athleteClient;

    StravaApiClient(AthleteClient athleteClient) {
        this.athleteClient = athleteClient;
    }

    public AthleteClient athlete() {
        return athleteClient;
    }
}