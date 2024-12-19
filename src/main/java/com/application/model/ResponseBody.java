package com.application.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseBody<T> {
    private T data;

    public ResponseBody(T data) {
        this.data = data;
    }
}
