package com.github.mertdeveci.exceptions.business;

import com.github.mertdeveci.exceptions.BusinessException;

public class BadRequestBusinessException extends BusinessException {
    public BadRequestBusinessException(String errorCode) {
        super(errorCode);
    }
}
