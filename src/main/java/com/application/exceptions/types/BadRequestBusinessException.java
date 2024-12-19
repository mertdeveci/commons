package com.application.exceptions.types;

import com.application.exceptions.BusinessException;

public class BadRequestBusinessException extends BusinessException {
    public BadRequestBusinessException(String errorCode) {
        super(errorCode);
    }
}
