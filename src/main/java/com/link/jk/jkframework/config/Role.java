package com.link.jk.jkframework.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {

    JK("ROLE_JK"),
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private String value;
}
