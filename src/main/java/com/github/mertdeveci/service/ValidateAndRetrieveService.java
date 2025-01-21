package com.github.mertdeveci.service;

import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.service.crud.RetrieveService;

import java.util.Optional;

public interface ValidateAndRetrieveService<T extends AbstractEntity> extends ValidateService, RetrieveService<T> {
    default Optional<T> validateAndRetrieve(Object validationObject, Long id){
        isValid(validationObject);
        return retrieveById(id);
    }
}
