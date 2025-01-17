package com.github.mertdeveci.service;

import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.service.crud.RetrieveService;

import java.util.Optional;

public interface ValidateAndRetrieveService extends ValidateService, RetrieveService {
    default <T extends AbstractEntity, ID extends Long> Optional<T> validateAndRetrieve(Object validationObject, ID id){
        isValid(validationObject);
        return retrieveById(id);
    }
}
