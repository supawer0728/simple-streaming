package com.parfait.study.simplewebfluxpub.user;

import com.parfait.study.simplestreaming.model.User;
import com.parfait.study.simplewebfluxpub.user.client.UserClient;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserClient userClient;

    @Autowired
    public UserController(@NonNull UserClient userClient) {
        this.userClient = userClient;
    }

    // 1초마다 User 발생
    @GetMapping(produces = "application/stream+json")
    public Flux<User> users() {

        return Flux.interval(Duration.ofSeconds(1L))
                   .take(3)
                   .flatMap(number -> userClient.get(number + 1L));
    }
}
