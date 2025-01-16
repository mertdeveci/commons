package com.github.mertdeveci.service;

import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.service.crud.RetrieveService;

import java.util.Optional;

public interface ValidateAndRetrieveService extends ValidateService, RetrieveService {

    <T extends AbstractEntity, ID extends Number> Optional<T> validateAndRetrieve(Object validationObject, ID id);


}
