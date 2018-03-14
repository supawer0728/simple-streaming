package com.parfait.study.simplestreaming.webfluxsub.user;

import com.parfait.study.simplestreaming.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users/flux-to-mono")
public class FluxToMonoController {

    @GetMapping
    public Mono<List<User>> fluxToFlux() {

        return WebClient.create("http://localhost:8080")
                        .get()
                        .uri("/users")
                        .retrieve()
                        .bodyToFlux(User.class)
                        .collect(Collectors.toList());
    }
}
