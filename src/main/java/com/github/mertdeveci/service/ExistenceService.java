package com.github.mertdeveci.service;

import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.exceptions.BusinessException;
import com.github.mertdeveci.exceptions.business.AlreadyExistsBusinessException;
import com.github.mertdeveci.exceptions.business.NotFoundBusinessException;

import java.util.Optional;
import java.util.function.Supplier;

public interface ExistenceService {
    <ID extends AbstractEntity> Optional<?> isExists(ID id);

    default <ID extends AbstractEntity> boolean exists(ID id){
        return isExists(id).isPresent();
    }

    default <ID extends AbstractEntity> void exists(ID id, String errorCode){
        exists(id, () -> { throw new AlreadyExistsBusinessException(errorCode); });
    }

    default  <ID extends AbstractEntity, E extends BusinessException> void exists(ID id, Supplier<E> e){
        if (!exists(id)){ e.get(); }
    }

    default <ID extends AbstractEntity> boolean absent(ID id) {
        return isExists(id).isEmpty();
    }

    default <ID extends AbstractEntity> void absent(ID id, String errorCode) {
        absent(id, () -> { throw new NotFoundBusinessException(errorCode); });
    }

    default <ID extends AbstractEntity, E extends BusinessException> void absent(ID id, Supplier<E> e){
        if (absent(id)){ e.get(); }
    }

}
