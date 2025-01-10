package com.application.service.crud;

import com.application.entity.AbstractEntity;
import com.application.exceptions.BusinessException;
import com.application.exceptions.business.NotFoundBusinessException;
import jakarta.annotation.Nonnull;

import java.util.Optional;
import java.util.function.Supplier;

public interface RetrieveService<ID, T extends AbstractEntity> {
   Optional<T> retrieveById(ID id);

   default T retrieveById(@Nonnull ID id, @Nonnull String errorCode) {
       return retrieveById(id, ()-> {throw new NotFoundBusinessException(errorCode);});
   }

   default <E extends BusinessException> T retrieveById(@Nonnull ID id, @Nonnull Supplier<E> e){
       return retrieveById(id).orElseThrow(e);
   }
}
