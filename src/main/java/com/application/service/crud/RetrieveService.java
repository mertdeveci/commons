package com.application.service.crud;

import com.application.entity.AbstractEntity;
import com.application.exceptions.ExceptionUtils;
import com.application.exceptions.Exceptions;

import java.util.Optional;

public interface RetrieveService<T extends AbstractEntity, ID> {
   Optional<T> retrieveById(ID id);

   default T retrieveById(ID id, String errorCode) {
       return retrieveById(id, Exceptions.NOT_FOUND, errorCode);
   }

   default <E extends ExceptionUtils> T retrieveById(ID id, E e, String errorCode){
       return retrieveById(id).orElseThrow(e.throwException(errorCode));
    }
}
