package com.github.mertdeveci.error;

public class DefaultErrorManager {
    private DefaultErrorManager() {}

    public static Error generate(String customErrorCode) {
        return new Error(customErrorCode);
    }

    public static Error generate(DefaultErrorTemplate errorTemplate, String customErrorCode) {
        String customizedErrorCode = String.format(errorTemplate.getErrorCode(), customErrorCode);
        return new Error(customizedErrorCode);
    }

}
