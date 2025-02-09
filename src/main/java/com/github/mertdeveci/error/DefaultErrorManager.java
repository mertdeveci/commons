package com.github.mertdeveci.error;

public class DefaultErrorManager {
    private DefaultErrorManager() {}

    public static DefaultError create(String customErrorCode) {
        return new DefaultError(customErrorCode);
    }

    public static DefaultError create(DefaultErrorTemplate errorTemplate, String customErrorCode) {
        String customizedErrorCode = String.format(errorTemplate.getErrorCode(), customErrorCode);
        return new DefaultError(customizedErrorCode);
    }

}
