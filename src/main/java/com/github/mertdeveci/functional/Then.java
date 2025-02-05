package com.github.mertdeveci.functional;

@FunctionalInterface
public interface Then<T> {
    T apply(T object);
}
