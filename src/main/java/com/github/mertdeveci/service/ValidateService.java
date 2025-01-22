package com.github.mertdeveci.service;

import com.github.mertdeveci.exceptions.validation.InvalidBusinessException;

import java.util.Objects;
import java.util.function.Supplier;

public interface ValidateService {
    <T> boolean isValid(T object);

    default <T, E extends InvalidBusinessException> void validate(T object, Supplier<E> e){
        if (isValid(object)) { e.get(); }
    }
}
