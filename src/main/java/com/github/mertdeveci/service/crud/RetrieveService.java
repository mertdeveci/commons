package com.github.mertdeveci.service.crud;

import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.exceptions.BusinessException;
import com.github.mertdeveci.exceptions.business.NotFoundBusinessException;
import jakarta.annotation.Nonnull;

import java.util.Optional;
import java.util.function.Supplier;

public interface RetrieveService {
    <T extends AbstractEntity> Optional<T> retrieveById(Long id);

    default <T extends AbstractEntity, E extends NotFoundBusinessException> T retrieveById(@Nonnull Long id, @Nonnull Supplier<E> e){
        Optional<T> entity = retrieveById(id);
        if (entity.isPresent()) {
            return entity.get();
        }
        throw e.get();
    }
}
