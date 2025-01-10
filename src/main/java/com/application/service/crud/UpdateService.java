package com.application.service.crud;

import com.application.entity.AbstractEntity;
import jakarta.annotation.Nonnull;

import java.util.List;

public interface UpdateService<T extends AbstractEntity> {
    void update(T entity);

    default void update(@Nonnull List<T> entities){
        entities.forEach(this::update);
    }
}
