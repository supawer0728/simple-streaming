package com.parfait.study.simplestreaming.webmvcpub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WebMvcPubApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebMvcPubApplication.class, args);
    }
}
