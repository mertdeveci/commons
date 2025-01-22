package com.github.mertdeveci.service;

import com.github.mertdeveci.exceptions.business.AlreadyExistsBusinessException;
import com.github.mertdeveci.exceptions.business.NotFoundBusinessException;

import java.util.function.Supplier;

public interface ExistenceService {
    boolean exists(Long id);

    default <T> T ifExistsThen(Long id, Supplier<T> apply){
        return exists(id) ? apply.get() : null;
    }

    default <E extends AlreadyExistsBusinessException> void isAlreadyExists(Long id, Supplier<E> e){
        if (exists(id)){ e.get(); }
    }

    default boolean notExists(Long id) {
        return !exists(id);
    }

    default <T> T ifNotExistsThen(Long id, Supplier<T> apply){
        return notExists(id) ? apply.get() : null;
    }

    default <E extends NotFoundBusinessException> void isNotFound(Long id, Supplier<E> e){
        if (notExists(id)){ e.get(); }
    }
}
