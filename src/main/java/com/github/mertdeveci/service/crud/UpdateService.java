package com.github.mertdeveci.service.crud;

import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.service.EntityService;
import jakarta.annotation.Nonnull;

import java.util.List;

public interface UpdateService<T extends AbstractEntity> extends EntityService {
    void update(T entity);

    default void update(@Nonnull List<T> entities){
        entities.forEach(this::update);
    }
}
