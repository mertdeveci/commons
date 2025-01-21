package com.github.mertdeveci.service;

import com.github.mertdeveci.exceptions.validation.InvalidBusinessException;

import java.util.Objects;
import java.util.function.Supplier;

public interface ValidateService {
    boolean isValid(Object o1);

    default void validate(Object object, String errorCode){
        validate(object, () -> { throw new InvalidBusinessException(errorCode); });
    }

    default <E extends InvalidBusinessException> void validate(Object object, Supplier<E> e){
        if (isValid(object)) { e.get(); }
    }

}
