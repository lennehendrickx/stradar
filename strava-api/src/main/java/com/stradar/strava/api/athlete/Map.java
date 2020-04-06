package com.stradar.strava.api.athlete;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.micronaut.core.annotation.Introspected;

@Introspected
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Map {

    private String id;
    private String summaryPolyline;

    public Map(String id, String summaryPolyline) {
        this.id = id;
        this.summaryPolyline = summaryPolyline;
    }

    public String getId() {
        return id;
    }

    public String getSummaryPolyline() {
        return summaryPolyline;
    }
}
