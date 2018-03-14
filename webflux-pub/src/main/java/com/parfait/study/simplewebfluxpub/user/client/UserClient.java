package com.parfait.study.simplewebfluxpub.user.client;

import com.parfait.study.simplestreaming.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Slf4j
@Component
public class UserClient {

    public Flux<User> get(long id) {

        return WebClient.create("https://jsonplaceholder.typicode.com")
                        .get()
                        .uri("/users/{id}", id)
                        .retrieve()
                        .bodyToFlux(User.class);
    }
}
