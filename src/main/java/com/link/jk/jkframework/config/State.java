package com.link.jk.jkframework.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum State {

    개발("DEV"),
    서비스("SERVICE");

    private String value;
}
