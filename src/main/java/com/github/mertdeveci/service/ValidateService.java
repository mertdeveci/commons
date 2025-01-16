package com.github.mertdeveci.service;

import com.github.mertdeveci.exceptions.validation.InvalidBusinessException;

import java.util.function.Supplier;

public interface ValidateService {
    <T> boolean isValid(T o1);

    default <T> void validate(T object, String errorCode){
        validate(object, () -> { throw new InvalidBusinessException(errorCode); });
    }

    default <T, E extends InvalidBusinessException> void validate(T object, Supplier<E> e){
        if (isValid(object)) { e.get(); }
    }

}
