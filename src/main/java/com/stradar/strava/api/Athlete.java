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