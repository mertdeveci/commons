package com.github.mertdeveci.service.functionals;

import com.github.mertdeveci.exceptions.BusinessException;

import java.util.function.Supplier;

public interface ExceptionSupplier<T extends BusinessException> extends Supplier<T> {
}
