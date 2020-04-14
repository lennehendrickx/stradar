package com.stradar.infrastructure.rest;

import static io.micronaut.security.rules.SecurityRule.IS_AUTHENTICATED;
import static java.util.Map.entry;

import com.stradar.application.ActivityService;
import com.stradar.application.User;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import java.util.Map;

@Controller("/api/activities")
public class ActivityController {

  private final ActivityService activityService;

  public ActivityController(ActivityService activityService) {
    this.activityService = activityService;
  }

  @Secured(IS_AUTHENTICATED)
  @Get
  public Map<String, Object> activities(User user) {
    return Map.ofEntries(
        entry("activities", activityService.getActivities(user).blockingIterable()));
  }
}
