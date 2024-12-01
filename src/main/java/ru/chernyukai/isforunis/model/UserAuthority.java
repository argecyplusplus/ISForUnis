package ru.chernyukai.isforunis.model;

import org.springframework.security.core.GrantedAuthority;

public enum UserAuthority implements GrantedAuthority {

    HEADMAN,
    PROFESSOR,
    DEAN;

    @Override
    public String getAuthority() {
        return this.name();
    }
}

