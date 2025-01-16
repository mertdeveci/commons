package com.github.mertdeveci.service;

import com.github.mertdeveci.entity.AbstractEntity;

import java.util.Optional;

public class TestService implements ValidateAndRetrieveService{

    @Override
    public <T extends AbstractEntity, ID> Optional<T> validateAndRetrieve(Object validationObject, ID id) {
        return Optional.empty();
    }

    @Override
    public <T> boolean isValid(T o1) {
        return false;
    }

    @Override
    public <T extends AbstractEntity, ID> Optional<T> retrieveById(ID id) {
        return Optional.empty();
    }
}
