package com.easy.domain;

import org.springframework.stereotype.Component;

@Component
public class User {
    public User() {
        System.out.println("User init");
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
