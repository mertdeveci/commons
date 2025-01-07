package com.application.service.crud;

import com.application.entity.AbstractEntity;
import com.application.exceptions.Throw;
import com.application.exceptions.CommonBusinessExceptions;

import java.util.Optional;

public interface RetrieveService<T extends AbstractEntity, ID> {
   Optional<T> retrieveById(ID id);

   default T retrieveById(ID id, String errorCode) {
       return retrieveById(id, CommonBusinessExceptions.NOT_FOUND, errorCode);
   }

   default <E extends Throw> T retrieveById(ID id, E e, String errorCode){
       return retrieveById(id).orElseThrow(e.throwException(errorCode));
   }
}
