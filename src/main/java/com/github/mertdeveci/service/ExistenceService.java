package com.github.mertdeveci.service;

import com.github.mertdeveci.exceptions.business.AlreadyExistsBusinessException;
import com.github.mertdeveci.exceptions.business.NotFoundBusinessException;

import java.util.function.Supplier;

public interface ExistenceService {
    boolean isExists(Long id);

    default <T> T ifExistsDo(Long id, Supplier<T> apply){
        return isExists(id) ? apply.get() : null;
    }

    default <E extends AlreadyExistsBusinessException> void isAlreadyExists(Long id, Supplier<E> e){
        if (isExists(id)){ e.get(); }
    }

    default boolean absent(Long id) {
        return !isExists(id);
    }

    default <T> T ifNotFoundDo(Long id, Supplier<T> apply){
        return absent(id) ? apply.get() : null;
    }

    default <E extends NotFoundBusinessException> void isNotFound(Long id, Supplier<E> e){
        if (absent(id)){ e.get(); }
    }
}
