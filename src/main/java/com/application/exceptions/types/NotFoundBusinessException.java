package com.application.exceptions.types;

import com.application.exceptions.BusinessException;

public class NotFoundBusinessException extends BusinessException {
    public NotFoundBusinessException(String errorCode) {
        super(errorCode);
    }
}
