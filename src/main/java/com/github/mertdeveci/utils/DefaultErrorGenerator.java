package com.github.mertdeveci.utils;

public class DefaultErrorGenerator {

    private DefaultErrorGenerator() {}

    public static Error of(String errorMessage) {
        return new Error(errorMessage);
    }

    public static class Error {
        public final String code;

        Error(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

}
