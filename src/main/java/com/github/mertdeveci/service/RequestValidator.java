package com.github.mertdeveci.service;

import com.github.mertdeveci.converter.Mapper;
import com.github.mertdeveci.exceptions.validation.InvalidBusinessException;
import com.github.mertdeveci.functional.ExceptionSupplier;

public interface RequestValidator<I, O extends Record> extends Mapper<I, O>, ValidatorService<I> {

    default <E extends InvalidBusinessException> O validateAndMap(I request, ExceptionSupplier<E> e) {
        this.validate(request, e);
        return this.convert(request);
    }
}
