package com.github.mertdeveci.exceptions;

public abstract class UtilsException extends BusinessException {
    private String errorMessage;
    private Throwable throwable;

    public UtilsException(String errorMessage) {
        super(errorMessage);
    }

    public UtilsException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
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
