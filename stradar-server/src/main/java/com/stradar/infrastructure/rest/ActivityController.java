package com.stradar.infrastructure.rest;

import static com.stradar.infrastructure.rest.UserFactory.toUser;
import static io.micronaut.security.rules.SecurityRule.IS_AUTHENTICATED;

import com.stradar.application.ActivityService;
import com.stradar.strava.api.athlete.Activity;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;
import io.reactivex.Flowable;

@Controller("/api/activities")
public class ActivityController {

  private final ActivityService activityService;

  public ActivityController(ActivityService activityService) {
    this.activityService = activityService;
  }

  @Secured(IS_AUTHENTICATED)
  @Get
  public Flowable<Activity> activities(Authentication authentication) {
    var user = toUser(authentication);
    return activityService.getActivities(user);
  }
}
