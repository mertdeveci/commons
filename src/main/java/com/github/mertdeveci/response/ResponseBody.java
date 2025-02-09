package com.github.mertdeveci.response;

public class ResponseBody<T> {
    private T data;

    public ResponseBody(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
