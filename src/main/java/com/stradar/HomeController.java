package com.stradar;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.views.View;

import java.util.Map;

import static io.micronaut.security.rules.SecurityRule.IS_ANONYMOUS;
import static java.util.Collections.emptyMap;

@Controller
public class HomeController {

    @Secured(IS_ANONYMOUS)
    @View("home")
    @Get
    public Map<String, Object> index() {
        return emptyMap();
    }
}