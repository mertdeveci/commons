package com.github.mertdeveci.service.crud;

import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.exceptions.business.NotFoundBusinessException;
import com.github.mertdeveci.service.functionals.ExceptionSupplier;
import com.github.mertdeveci.service.functionals.Validator;
import jakarta.annotation.Nonnull;

import java.util.Optional;

public abstract class RetrieveService<T extends AbstractEntity> {
    protected abstract Optional<T> retrieveById(Long id);
    private final String DEFAULT_ERROR_MESSAGE;

    public RetrieveService(String defaultErrorMessage) {
        DEFAULT_ERROR_MESSAGE = defaultErrorMessage;
    }

    public T retrieveByIdOrElseThrow(@Nonnull Long id){
        return retrieveByIdOrElseThrow(id, () -> new NotFoundBusinessException(DEFAULT_ERROR_MESSAGE));
    }

    public <E extends NotFoundBusinessException> T retrieveByIdOrElseThrow(@Nonnull Long id, @Nonnull ExceptionSupplier<E> e){
        Optional<T> entity = retrieveById(id);
        if (entity.isEmpty()) {
            throw e.get();
        }
        return entity.get();
    }

    public T retrieveAndValidate(Long id, Validator<T> validator){
        return retrieveById(id).map(validator::validate).orElse(null);
    }
}
