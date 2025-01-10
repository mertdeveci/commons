package com.application.enums;

public enum EntityStatus {
    DELETED("deleted"),
    PASSIVE("passive"),
    ACTIVE("active");

    private final String status;

    EntityStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
