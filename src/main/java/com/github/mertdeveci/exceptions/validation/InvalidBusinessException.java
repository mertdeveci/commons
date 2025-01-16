package com.github.mertdeveci.exceptions.validation;

import com.github.mertdeveci.exceptions.BusinessException;

public class InvalidBusinessException extends BusinessException {
    public InvalidBusinessException(String errorCode) {
        super(errorCode);
    }

    public InvalidBusinessException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }
}
