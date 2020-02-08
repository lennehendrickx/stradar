package com.stradar;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/conferences")
public class PhotoController {

    private final PhotoService conferenceService;

    public PhotoController(PhotoService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @Get("/random")
    public Photo randomPhoto() {
        return conferenceService.randomPhoto();
    }
}