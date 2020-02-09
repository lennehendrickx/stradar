package com.stradar.strava.api;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.micronaut.core.annotation.Introspected;

@Introspected
@JsonNaming(SnakeCaseStrategy.class)
public class Activity {

    private String name;

    public Activity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

/*
Example JSON
{
    "resource_state": 2,
    "athlete": {
        "id": 2153161,
        "resource_state": 1
    },
    "name": "Afternoon Run",
    "distance": 5011.5,
    "moving_time": 1516,
    "elapsed_time": 1614,
    "total_elevation_gain": 14.3,
    "type": "Run",
    "workout_type": null,
    "id": 3085741513,
    "external_id": "garmin_push_4531922147",
    "upload_id": 3294317884,
    "start_date": "2020-02-09T14:09:44Z",
    "start_date_local": "2020-02-09T15:09:44Z",
    "timezone": "(GMT+01:00) Europe/Brussels",
    "utc_offset": 3600.0,
    "start_latlng": [
        50.917614,
        4.71659
    ],
    "end_latlng": [
        50.917792,
        4.716547
    ],
    "location_city": null,
    "location_state": null,
    "location_country": "Belgium",
    "start_latitude": 50.917614,
    "start_longitude": 4.71659,
    "achievement_count": 0,
    "kudos_count": 12,
    "comment_count": 0,
    "athlete_count": 1,
    "photo_count": 0,
    "map": {
        "id": "a3085741513",
        "summary_polyline": "adwuH}zz[]_C{@gJa@cDuAcHk@sBQ_A[cAu@cEs@qEYmCi@iIYgDe@_DGWSUUJyApAkDtBm@Xi@^c@d@u@h@e@h@sAhAsAv@a@d@kAv@MZDl@L^LdALr@N\\PdB@fCX|B\\nBFl@I~F]t@[b@IPwAnFy@rDeBpI}@pDQ~@CX",
        "resource_state": 2
    },
    "trainer": false,
    "commute": false,
    "manual": false,
    "private": false,
    "visibility": "everyone",
    "flagged": false,
    "gear_id": null,
    "from_accepted_tag": false,
    "upload_id_str": "3294317884",
    "average_speed": 3.306,
    "max_speed": 4.7,
    "average_cadence": 80.1,
    "has_heartrate": true,
    "average_heartrate": 158.3,
    "max_heartrate": 173.0,
    "heartrate_opt_out": false,
    "display_hide_heartrate_option": true,
    "elev_high": 23.6,
    "elev_low": 12.4,
    "pr_count": 0,
    "total_photo_count": 0,
    "has_kudoed": false
}
 */