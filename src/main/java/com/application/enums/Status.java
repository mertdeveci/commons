package com.application.enums;

public enum Status {
    DELETED("deleted"),
    PASSIVE("passive"),
    ACTIVE("active");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
