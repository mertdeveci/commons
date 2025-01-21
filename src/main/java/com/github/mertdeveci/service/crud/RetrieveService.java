package com.github.mertdeveci.service.crud;

import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.exceptions.BusinessException;
import com.github.mertdeveci.exceptions.business.NotFoundBusinessException;
import jakarta.annotation.Nonnull;

import java.util.Optional;
import java.util.function.Supplier;

public interface RetrieveService<T extends AbstractEntity> {
    Optional<T> retrieveById(Long id);

    default T retrieveById(@Nonnull Long id, @Nonnull String errorCode) {
       return retrieveById(id, ()-> { throw new NotFoundBusinessException(errorCode); });
    }

    default <ID extends Long, E extends BusinessException> T retrieveById(@Nonnull ID id, @Nonnull Supplier<E> e){
        return retrieveById(id).orElseThrow(e);
    }
}
