package com.application.exceptions;

public abstract class BusinessException extends RuntimeException {
    private String errorCode;

    public BusinessException(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
