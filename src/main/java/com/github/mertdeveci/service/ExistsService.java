package com.github.mertdeveci.service;

import com.github.mertdeveci.exceptions.BusinessException;
import com.github.mertdeveci.exceptions.business.AlreadyExistsBusinessException;

import java.util.function.Supplier;

public interface ExistsService<ID> {
    boolean exists(ID id);

    default void exists(ID id, String errorCode){
        exists(id, () -> {throw new AlreadyExistsBusinessException(errorCode);});
    }

    default <E extends BusinessException> void exists(ID id, Supplier<E> e){
        if (!exists(id)){
            e.get();
        }
    }

    default boolean absent(ID id) {
        return !exists(id);
    }

    default <E extends BusinessException> void absent(ID id, Supplier<E> e){
        if (absent(id)){
            e.get();
        }
    }

}
