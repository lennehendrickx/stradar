package com.stradar.infrastructure.rest;

import static com.stradar.infrastructure.rest.UserFactory.toUser;
import static io.micronaut.security.rules.SecurityRule.IS_AUTHENTICATED;

import com.stradar.application.User;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;
import io.reactivex.Single;

@Controller("/api/user")
public class UserController {

  @Secured(IS_AUTHENTICATED)
  @Get
  public Single<UserProfile> user(Authentication authentication) {
    var user = toUser(authentication);
    return Single.just(toUserProfile(user));
  }

  private static UserProfile toUserProfile(User user) {
    return new UserProfile(
        user.getUsername(),
        user.getFirstname(),
        user.getLastname(),
        user.getCity(),
        user.getCountry(),
        user.getSex(),
        user.getFriendCount(),
        user.getFollowerCount(),
        user.getProfile(),
        user.getWeight());
  }
}
