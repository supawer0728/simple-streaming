package com.parfait.study.simplestreaming.webfluxsub.user;

import com.parfait.study.simplestreaming.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/users/flux-to-flux")
public class FluxToFluxController {

    @GetMapping(produces = "application/stream+json")
    public Flux<User> fluxToFlux() {

        return WebClient.create("http://localhost:8080")
                        .get()
                        .uri("/users")
                        .retrieve()
                        .bodyToFlux(User.class);
    }
}
