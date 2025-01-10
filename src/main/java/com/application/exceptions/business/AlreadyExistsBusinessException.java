package com.application.exceptions.business;

import com.application.exceptions.BusinessException;

public class AlreadyExistsBusinessException extends BusinessException {
    public AlreadyExistsBusinessException(String errorCode) {
        super(errorCode);
    }
}
