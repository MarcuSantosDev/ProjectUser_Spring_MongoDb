package com.cursojava.projeto_spring_mongo.dto;

import com.cursojava.projeto_spring_mongo.domain.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {
    private static final Long serialVersionUID = 1L;
    private String id;
    private String name;

    public AuthorDTO() {
    }

    public AuthorDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
