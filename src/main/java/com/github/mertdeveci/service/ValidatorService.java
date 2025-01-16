package com.github.mertdeveci.service;

import com.github.mertdeveci.exceptions.BusinessException;
import com.github.mertdeveci.exceptions.validation.InvalidBusinessException;

import java.util.function.Supplier;

public interface ValidatorService {
    <T> boolean isValid(T o1);

    default <T> void validate(T o1, String errorCode){
        if (isValid(o1)) {
            throw new InvalidBusinessException(errorCode);
        }
    }

    default <T, E extends BusinessException> void validate(T o1, Supplier<E> exception){
        if (isValid(o1)) {
           exception.get();
        }
    }

}
