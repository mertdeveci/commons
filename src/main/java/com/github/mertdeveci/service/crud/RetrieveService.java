package com.github.mertdeveci.service.crud;

import com.github.mertdeveci.converter.VoMapper;
import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.exceptions.business.NotFoundBusinessException;
import com.github.mertdeveci.functional.ExceptionSupplier;
import com.github.mertdeveci.functional.Then;
import com.github.mertdeveci.utils.DefaultErrorGenerator;
import jakarta.annotation.Nonnull;

import java.util.Optional;

public interface RetrieveService<T extends AbstractEntity> {
    Optional<T> retrieveById(Long id);

    default <E extends NotFoundBusinessException> T retrieveOrElseThrow(@Nonnull Long id, @Nonnull ExceptionSupplier<E> e){
        return retrieveById(id).orElseThrow(e);
    }

    default T retrieveOrElseThrow(@Nonnull Long id, @Nonnull DefaultErrorGenerator.Error error) {
        return retrieveById(id).orElseThrow(() -> new NotFoundBusinessException(error.getCode()));
    }

    default T retrieveAndThen(Long id, Then<T> then){
        return retrieveById(id).map(then::apply).orElse(null);
    }

    default <R extends Record> R retrieveAndMap(Long id, VoMapper<T, R> mapper){
        return retrieveById(id).map(mapper::convert).orElse(null);
    }

    default <R extends Record, E extends NotFoundBusinessException> R retrieveAndMap(Long id, VoMapper<T, R> mapper, ExceptionSupplier<E> e){
        return retrieveById(id).map(mapper::convert).orElseThrow(e);
    }
}
