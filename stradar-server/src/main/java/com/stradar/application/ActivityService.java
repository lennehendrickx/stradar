package com.stradar.application;

import static com.stradar.strava.api.BearerToken.bearerToken;

import com.stradar.strava.api.StravaApiClient;
import com.stradar.strava.api.athlete.Activity;
import io.reactivex.Flowable;
import javax.inject.Singleton;

@Singleton
public class ActivityService {

  private final StravaApiClient apiClient;

  public ActivityService(StravaApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public Flowable<Activity> getActivities(User user) {
    var bearerToken = bearerToken(user.getAccessToken());
    return apiClient.athlete().activities(bearerToken);
  }
}
