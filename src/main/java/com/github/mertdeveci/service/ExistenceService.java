package com.github.mertdeveci.service;

import com.github.mertdeveci.exceptions.business.AlreadyExistsBusinessException;
import com.github.mertdeveci.exceptions.business.NotFoundBusinessException;

import java.util.function.Supplier;

public interface ExistenceService {
    boolean isExists(Long id);

    default void ifExists(Long id, Supplier<Void> apply){
        if (isExists(id)){ apply.get(); }
    }

    default void isAlreadyExists(Long id, String errorCode){
        isAlreadyExists(id, () -> { throw new AlreadyExistsBusinessException(errorCode); });
    }

    default <E extends AlreadyExistsBusinessException> void isAlreadyExists(Long id, Supplier<E> e){
        if (isExists(id)){ e.get(); }
    }

    default boolean absent(Long id) {
        return !isExists(id);
    }

    default void ifNotFound(Long id, Supplier<Void> apply){
        if (absent(id)){ apply.get(); }
    }

    default void isNotFound(Long id, String errorCode) {
        isNotFound(id, ()->{ throw new  NotFoundBusinessException(errorCode); });
    }

    default <E extends NotFoundBusinessException> void isNotFound(Long id, Supplier<E> e){
        if (absent(id)){ e.get(); }
    }

}
