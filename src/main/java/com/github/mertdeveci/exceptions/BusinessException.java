package com.github.mertdeveci.exceptions;

public abstract class BusinessException extends RuntimeException {
    private String errorCode;
    private Throwable throwable;

    public BusinessException(String errorCode) {
        this.errorCode = errorCode;
    }

    public BusinessException(String errorMessage, Throwable throwable) {
        this.errorCode = errorMessage;
        this.throwable = throwable;
    };

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
