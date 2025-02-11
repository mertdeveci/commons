package com.github.mertdeveci.request;

import com.github.mertdeveci.converter.mapper.Mapper;
import com.github.mertdeveci.exceptions.validation.InvalidBusinessException;
import com.github.mertdeveci.functional.ExceptionSupplier;
import com.github.mertdeveci.service.ValidatorService;

public interface RequestHandler<I, O extends Record> extends Mapper<I, O>, ValidatorService<I> {

    default <E extends InvalidBusinessException> O validateAndMap(I request, ExceptionSupplier<E> validationException) {
        this.validate(request, validationException);
        return this.convert(request);
    }
}
