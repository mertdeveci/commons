package com.github.mertdeveci.service.crud;

import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.exceptions.business.NotFoundBusinessException;
import jakarta.annotation.Nonnull;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public interface RetrieveService<T extends AbstractEntity> {
    Optional<T> retrieveById(Long id);

    default <E extends NotFoundBusinessException> T retrieveById(@Nonnull Long id, @Nonnull Supplier<E> e){
        Optional<T> entity = retrieveById(id);
        if (entity.isPresent()) {
            return entity.get();
        }
        throw e.get();
    }

    default T retrieveAndValidate(Long id, Consumer<T> validatorConsumer){
        Optional<T> optional = retrieveById(id);
        if (optional.isPresent()) {
            validatorConsumer.accept(optional.get());
            return optional.get();
        }
        return null;
    }
}
