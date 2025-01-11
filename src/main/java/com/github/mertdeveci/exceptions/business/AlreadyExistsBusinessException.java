package com.github.mertdeveci.exceptions.business;

import com.github.mertdeveci.exceptions.BusinessException;

public class AlreadyExistsBusinessException extends BusinessException {
    public AlreadyExistsBusinessException(String errorCode) {
        super(errorCode);
    }
}
