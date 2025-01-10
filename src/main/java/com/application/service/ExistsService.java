package com.application.service;

import com.application.exceptions.BusinessException;
import com.application.exceptions.types.AlreadyExistsBusinessException;

import java.util.function.Supplier;

public interface ExistsService<ID> {
    boolean exists(ID id);

    default void exists(ID id, String errorCode){
        exists(id, () -> {throw new AlreadyExistsBusinessException(errorCode);});
    }

    default <E extends BusinessException> void exists(ID id, Supplier<E> e){
        if (exists(id)){
            e.get();
        }
    }

    default boolean absent(ID id) {
        return !exists(id);
    }

    default void absent(ID id, String errorCode){
        notExists(id, () -> {throw new AlreadyExistsBusinessException(errorCode);});
    }

    default <E extends BusinessException> void notExists(ID id, Supplier<E> e){
        if (absent(id)){
            e.get();
        }
    }

}
