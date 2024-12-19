package com.application.service.crud;

import com.application.entity.AbstractEntity;

import java.util.List;

public interface DeleteService<T extends AbstractEntity> {
    void delete(T entity);

    default void delete(List<T> entities){
        entities.forEach(this::delete);
    }
}
