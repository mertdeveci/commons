package com.github.mertdeveci.service;

import com.github.mertdeveci.entity.AbstractStatusEntity;
import com.github.mertdeveci.enums.Status;

public interface EntityService {
    default <T extends AbstractStatusEntity> void changeStatus(T entity, Status status){
        entity.setStatus(status);
    }

    default <T extends AbstractStatusEntity> void activate(T entity){
        changeStatus(entity, Status.ACTIVE);
    }

    default <T extends AbstractStatusEntity> void passivate(T entity){
        changeStatus(entity, Status.PASSIVE);
    }

    default <T extends AbstractStatusEntity> void delete(T entity){
        changeStatus(entity, Status.DELETED);
    }
}
