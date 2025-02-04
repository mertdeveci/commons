package com.github.mertdeveci.service.crud;

import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.exceptions.business.NotFoundBusinessException;
import com.github.mertdeveci.service.ExceptionSupplier;
import jakarta.annotation.Nonnull;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public interface RetrieveService<T extends AbstractEntity> {
    Optional<T> retrieveById(Long id);

    default T retrieveByIdOrElseThrow(@Nonnull Long id){
        return retrieveById(id).orElseThrow(() -> new NotFoundBusinessException(DEFAULT_ERROR_MESSAGE));
    }

    default <E extends NotFoundBusinessException> T retrieveByIdOrElseThrow(@Nonnull Long id, @Nonnull ExceptionSupplier<E> e){
        Optional<T> entity = retrieveById(id);
        if (entity.isEmpty()) {
            throw e.get();
        }
        return entity.get();
    }

    default T retrieveAndValidate(Long id, Consumer<T> validatorConsumer){
        Optional<T> optional = retrieveById(id);
        if (optional.isEmpty()) {
            return null;
        }
        validatorConsumer.accept(optional.get());
        return optional.get();
    }
}
