package com.application.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    private String status;
    private String message;
    private boolean error;
    private String errorCode;
    private String local;
    private long systemTime;
    private ResponseBody<?> body;
}
