package com.github.mertdeveci.exceptions.business;

public class EntityNotFoundBusinessException extends NotFoundBusinessException {
    public EntityNotFoundBusinessException(String errorCode) {
        super(errorCode);
    }
}
