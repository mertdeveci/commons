package com.github.mertdeveci.error;

public enum DefaultErrorTemplate {
    DEFAULT_RETRIEVE_ERROR_CODE("%s is not found!"),
    DEFAULT_EXISTS_ERROR_CODE("%s is not exists!"),
    DEFAULT_ALREADY_EXISTS_ERROR_CODE("%s is already exists!"),
    DEFAULT_NOT_VALID_ERROR_CODE("%s is not valid!");

    private final String errorCode;

    DefaultErrorTemplate(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
