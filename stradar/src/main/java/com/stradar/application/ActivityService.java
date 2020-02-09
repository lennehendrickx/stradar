package com.stradar.application;

import com.stradar.strava.api.StravaApiClient;
import com.stradar.strava.api.athlete.Activity;
import io.micronaut.security.authentication.Authentication;
import io.reactivex.Flowable;

import javax.inject.Singleton;

import static com.stradar.application.AuthenticationUtil.toBearerToken;

@Singleton
public class ActivityService {

    private final StravaApiClient apiClient;

    public ActivityService(StravaApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Flowable<Activity> getActivities(Authentication authentication) {
        return apiClient.athlete().activities(toBearerToken(authentication));
    }
}