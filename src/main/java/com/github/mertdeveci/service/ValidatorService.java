package com.github.mertdeveci.service;

import com.github.mertdeveci.exceptions.validation.InvalidBusinessException;
import com.github.mertdeveci.functional.ExceptionSupplier;

public interface ValidatorService<T> {
    boolean isValid(T object);

    default <E extends InvalidBusinessException> void validate(T object, ExceptionSupplier<E> e){
        if (!isValid(object)) { e.get(); }
    }
}
