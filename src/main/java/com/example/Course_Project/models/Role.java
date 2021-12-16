package com.example.Course_Project.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    DIRECTOR,
    MANAGER,
    WORKER;

    @Override
    public String getAuthority() {
        return name();
    }
}