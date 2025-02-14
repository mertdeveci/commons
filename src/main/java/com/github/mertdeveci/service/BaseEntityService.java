package com.github.mertdeveci.service;

import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.entity.AbstractStatusEntity;
import com.github.mertdeveci.enums.Status;
import org.springframework.util.Assert;

public interface BaseEntityService {
    <T extends AbstractEntity> T save(T entity);

    default <T extends AbstractStatusEntity> void delete(T entity){
        Assert.isTrue(Status.DELETED.equals(entity.getStatus()), "Entity is already deleted!");
        entity.setStatus(Status.DELETED);
        this.save(entity);
    }

    default <T extends AbstractStatusEntity> void activate(T entity){
        Assert.isTrue(Status.DELETED.equals(entity.getStatus()), "Deleted entity cannot be activated!");
        entity.setStatus(Status.ACTIVE);
        this.save(entity);
    }

    default <T extends AbstractStatusEntity> void passivate(T entity){
        Assert.isTrue(Status.DELETED.equals(entity.getStatus()), "Deleted entity cannot be passivated!");
        entity.setStatus(Status.PASSIVE);
        this.save(entity);
    }
}
