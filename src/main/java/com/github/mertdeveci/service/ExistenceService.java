package com.github.mertdeveci.service;

import com.github.mertdeveci.exceptions.BusinessException;
import com.github.mertdeveci.exceptions.business.AlreadyExistsBusinessException;
import com.github.mertdeveci.exceptions.business.NotFoundBusinessException;

import java.util.Optional;
import java.util.function.Supplier;

public interface ExistenceService<ID> {
    Optional<?> isPresent(ID id);

    default boolean exists(ID id){
        return isPresent(id).isPresent();
    }

    default void exists(ID id, String errorCode){
        exists(id, () -> { throw new AlreadyExistsBusinessException(errorCode); });
    }

    default <E extends BusinessException> void exists(ID id, Supplier<E> e){
        if (!exists(id)){ e.get(); }
    }

    default boolean absent(ID id) {
        return isPresent(id).isEmpty();
    }

    default void absent(ID id, String errorCode) {
        absent(id, () -> { throw new NotFoundBusinessException(errorCode); });
    }

    default <E extends BusinessException> void absent(ID id, Supplier<E> e){
        if (absent(id)){ e.get(); }
    }

}
