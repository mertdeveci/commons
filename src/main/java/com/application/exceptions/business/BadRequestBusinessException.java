package com.application.exceptions.business;

import com.application.exceptions.BusinessException;

public class BadRequestBusinessException extends BusinessException {
    public BadRequestBusinessException(String errorCode) {
        super(errorCode);
    }
}
