package com.github.mertdeveci.service.functionals;

@FunctionalInterface
public interface Then<T> {
    T apply(T object);
}
