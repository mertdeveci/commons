package com.github.mertdeveci.service;

import com.github.mertdeveci.exceptions.validation.InvalidBusinessException;

import java.util.Objects;
import java.util.function.Supplier;

public interface ValidateService {
    boolean isValid(Object object);

    default <E extends InvalidBusinessException> void validate(Object object, Supplier<E> e){
        if (isValid(object)) { e.get(); }
    }
}
