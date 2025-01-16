package com.github.mertdeveci.service;

import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.exceptions.BusinessException;
import com.github.mertdeveci.exceptions.business.AlreadyExistsBusinessException;
import com.github.mertdeveci.exceptions.business.NotFoundBusinessException;
import com.github.mertdeveci.exceptions.validation.InvalidBusinessException;

import java.util.function.Supplier;

public interface ExistenceValidatorService extends ExistenceService {
    <T> boolean isValid(T o1);

    default <T> void validate(T object, String errorCode){
        if (isValid(object)) { throw new InvalidBusinessException(errorCode); }
    }

    default <T, E extends BusinessException> void validate(T object, Supplier<E> exception){
        if (isValid(object)) { exception.get(); }
    }

    default <ID extends AbstractEntity> void isAlreadyExists(ID id, String errorCode){
        isAlreadyExists(id, () -> { throw new AlreadyExistsBusinessException(errorCode); });
    }

    default <ID extends AbstractEntity, E extends BusinessException> void isAlreadyExists(ID id, Supplier<E> exception){
        exists(id, exception);
    }

    default <ID extends AbstractEntity> void isNotExists(ID id, String errorCode){
        absent(id, () -> { throw new NotFoundBusinessException(errorCode); });
    }

    default <ID extends AbstractEntity, E extends BusinessException> void isNotExists(ID id, Supplier<E> exception){
        absent(id, exception);
    }



}
