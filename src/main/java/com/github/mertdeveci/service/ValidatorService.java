package com.github.mertdeveci.service;

import com.github.mertdeveci.exceptions.BusinessException;
import com.github.mertdeveci.exceptions.validation.InvalidBusinessException;

import java.util.function.Supplier;

public interface ValidatorService {
    <T> boolean isValid(T o1);

    default <T> void validate(T object, String errorCode){
        if (isValid(object)) { throw new InvalidBusinessException(errorCode); }
    }

    default <T, E extends BusinessException> void validate(T object, Supplier<E> exception){
        if (isValid(object)) { exception.get(); }
    }

}
