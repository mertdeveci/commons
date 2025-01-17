package com.github.mertdeveci.service;

import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.exceptions.BusinessException;
import com.github.mertdeveci.exceptions.business.AlreadyExistsBusinessException;
import com.github.mertdeveci.exceptions.business.NotFoundBusinessException;

import java.util.function.Supplier;

public interface ExistenceService {
    <ID extends Long> boolean isExists(ID id);

    default <ID extends Long> void isAlreadyExists(ID id, String errorCode){
        isAlreadyExists(id, () -> { throw new AlreadyExistsBusinessException(errorCode); });
    }

    default <ID extends Long, E extends AlreadyExistsBusinessException> void isAlreadyExists(ID id, Supplier<E> e){
        if (isExists(id)){ e.get(); }
    }

    default <ID extends Long> boolean absent(ID id) {
        return !isExists(id);
    }

    default <ID extends Long> void isNotFound(ID id, String errorCode) {
        isNotFound(id, ()->{ throw new  NotFoundBusinessException(errorCode); });
    }

    default <ID extends Long, E extends NotFoundBusinessException> void isNotFound(ID id, Supplier<E> e){
        if (absent(id)){ e.get(); }
    }

}
