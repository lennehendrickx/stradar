package com.stradar.domain;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class Photo {

    private String name;

    public Photo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}