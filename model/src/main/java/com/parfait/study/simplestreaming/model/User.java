package com.parfait.study.simplestreaming.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String website;
}
