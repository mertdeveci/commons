package com.github.mertdeveci.exceptions.business;

import com.github.mertdeveci.exceptions.BusinessException;

public class NotFoundBusinessException extends BusinessException {
    public NotFoundBusinessException(String errorCode) {
        super(errorCode);
    }
}
