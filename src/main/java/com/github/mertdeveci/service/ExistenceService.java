package com.github.mertdeveci.service;

import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.exceptions.BusinessException;
import com.github.mertdeveci.exceptions.business.AlreadyExistsBusinessException;
import com.github.mertdeveci.exceptions.business.NotFoundBusinessException;

import java.util.Optional;
import java.util.function.Supplier;

public interface ExistenceService {
    <ID extends AbstractEntity> boolean isExists(ID id);

    default <ID extends AbstractEntity> void isAlreadyExists(ID id, String errorCode){
        isAlreadyExists(id, () -> { throw new AlreadyExistsBusinessException(errorCode); });
    }

    default  <ID extends AbstractEntity, E extends BusinessException> void isAlreadyExists(ID id, Supplier<E> e){
        if (isExists(id)){ e.get(); }
    }

    default <ID extends AbstractEntity> boolean absent(ID id) {
        return !isExists(id);
    }

    default <ID extends AbstractEntity> void isNotFound(ID id, String errorCode) {
        isNotFound(id, ()->{ throw new  NotFoundBusinessException(errorCode); });
    }

    default <ID extends AbstractEntity, E extends BusinessException> void isNotFound(ID id, Supplier<E> e){
        if (absent(id)){ e.get(); }
    }

}
