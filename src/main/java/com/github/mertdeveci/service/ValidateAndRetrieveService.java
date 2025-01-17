package com.github.mertdeveci.service;

import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.service.crud.RetrieveService;

import java.util.Optional;

public interface ValidateAndRetrieveService<T extends AbstractEntity> extends ValidateService, RetrieveService<T> {
    default <ID extends Long> Optional<T> validateAndRetrieve(Object validationObject, ID id){
        isValid(validationObject);
        return retrieveById(id);
    }
}
