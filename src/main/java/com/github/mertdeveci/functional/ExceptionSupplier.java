package com.github.mertdeveci.functional;

import com.github.mertdeveci.exceptions.BusinessException;

import java.util.function.Supplier;

public interface ExceptionSupplier<T extends BusinessException> extends Supplier<T> {
}
