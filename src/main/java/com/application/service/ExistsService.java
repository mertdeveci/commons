package com.application.service;

import com.application.exceptions.CommonBusinessExceptions;

import static com.application.exceptions.CommonBusinessExceptions.ALREADY_EXISTS;
import static com.application.exceptions.CommonBusinessExceptions.NOT_FOUND;

public interface ExistsService<ID> {
    boolean exists(ID id);

    default void exists(ID id, String errorCode){
        exists(id, ALREADY_EXISTS, errorCode);
    }

    default void exists(ID id, CommonBusinessExceptions e, String errorCode){
        if (exists(id)){
            e.throwException(errorCode);
        }
    }

    default boolean absent(ID id) {
        return !exists(id);
    }

    default void absent(ID id, String errorCode){
        notExists(id, NOT_FOUND, errorCode);
    }

    default void notExists(ID id, CommonBusinessExceptions e, String errorCode){
        if (absent(id)){
            e.throwException(errorCode);
        }
    }

}
