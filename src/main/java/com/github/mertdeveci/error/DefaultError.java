package com.github.mertdeveci.error;

public class DefaultError {
    private final String code;

    public DefaultError(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
