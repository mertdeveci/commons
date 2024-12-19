package com.application.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EntityStatus {
    DELETED,
    PASSIVE,
    ACTIVE;
}
