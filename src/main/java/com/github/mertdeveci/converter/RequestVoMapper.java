package com.github.mertdeveci.converter;

import com.github.mertdeveci.exceptions.validation.InvalidBusinessException;
import com.github.mertdeveci.functional.ExceptionSupplier;
import com.github.mertdeveci.service.ValidateService;

public interface RequestVoMapper<I, O extends Record> extends Mapper<I, O>, ValidateService<I> {

    default <E extends InvalidBusinessException> O validateAndMap(I input, ExceptionSupplier<E> e) {
        this.validate(input, e);
        return this.convert(input);
    }
}
