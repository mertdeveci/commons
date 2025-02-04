package com.github.mertdeveci.service.functionals;

@FunctionalInterface
public interface Validator<T> {
    T validate(T object);
}
