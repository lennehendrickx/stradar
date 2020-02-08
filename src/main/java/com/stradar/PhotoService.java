package com.stradar;

import javax.inject.Singleton;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Singleton
public class PhotoService {

    private static final List<Photo> PHOTOS = Arrays.asList(
            new Photo("Greach"),
            new Photo("GR8Conf EU"),
            new Photo("Micronaut Summit"),
            new Photo("Devoxx Belgium"),
            new Photo("Oracle Code One"),
            new Photo("CommitConf"),
            new Photo("Codemotion Madrid")
    );

    public Photo randomPhoto() {
        return PHOTOS.get(new Random().nextInt(PHOTOS.size()));
    }
}