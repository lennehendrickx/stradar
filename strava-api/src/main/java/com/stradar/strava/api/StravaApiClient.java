package com.stradar.strava.api;

import com.stradar.strava.api.athlete.AthleteClient;
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
