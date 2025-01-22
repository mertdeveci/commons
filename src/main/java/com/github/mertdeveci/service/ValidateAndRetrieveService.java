package com.github.mertdeveci.service;

import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.service.crud.RetrieveService;

import java.util.Optional;

public interface ValidateAndRetrieveService extends ValidateService, RetrieveService {
    default <O extends AbstractEntity, I> Optional<O> validateAndRetrieve(I validationObject, Long id){
        isValid(validationObject);
        return retrieveById(id);
    }
}
