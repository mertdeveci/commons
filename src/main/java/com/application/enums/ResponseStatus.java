package com.application.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseStatus {
    SUCCESS("success"),
    ERROR("error");

    private final String status;
}
