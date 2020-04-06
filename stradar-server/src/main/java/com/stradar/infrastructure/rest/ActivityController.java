package com.stradar.infrastructure.rest;

import com.stradar.application.ActivityService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;

import java.util.Map;

import static io.micronaut.security.rules.SecurityRule.IS_AUTHENTICATED;
import static java.util.Map.entry;

@Controller("/api/activities")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @Secured(IS_AUTHENTICATED)
    @Get
    public Map<String, Object> activities(Authentication authentication) {
        return Map.ofEntries(
                entry("activities", activityService
                        .getActivities(authentication)
                        .blockingIterable()));
    }

}