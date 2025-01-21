package com.github.mertdeveci.service;

import com.github.mertdeveci.entity.AbstractEntity;

import java.util.Optional;

public class TestService implements ExistenceValidationService {
    @Override
    public <ID extends AbstractEntity> Optional<?> isExists(ID id) {
        return Optional.empty();
    }

    @Override
    public <T> boolean isValid(T o1) {
        return false;
    }
}
