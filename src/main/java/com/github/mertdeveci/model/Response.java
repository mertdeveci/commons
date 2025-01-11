package com.github.mertdeveci.model;

public class Response {
    private String status;
    private String message;
    private boolean error;
    private String errorCode;
    private String local;
    private long systemTime;
    private ResponseBody<?> body;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public long getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(long systemTime) {
        this.systemTime = systemTime;
    }

    public ResponseBody<?> getBody() {
        return body;
    }

    public void setBody(ResponseBody<?> body) {
        this.body = body;
    }
}
