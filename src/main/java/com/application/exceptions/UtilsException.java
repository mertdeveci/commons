package com.application.exceptions;

public abstract class UtilsException extends RuntimeException {
    private String errorMessage;
    private Throwable throwable;

    public UtilsException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public UtilsException(String errorMessage, Throwable throwable) {
        this.errorMessage = errorMessage;
        this.throwable = throwable;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
