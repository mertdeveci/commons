package com.github.mertdeveci.functional;

import com.github.mertdeveci.exceptions.BusinessException;

import java.util.function.Supplier;

@FunctionalInterface
public interface ExceptionSupplier<T extends BusinessException> extends Supplier<T> {
}
