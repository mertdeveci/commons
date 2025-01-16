package com.github.mertdeveci.service.crud;

import com.github.mertdeveci.entity.AbstractEntity;
import jakarta.annotation.Nonnull;

import java.util.List;

public interface UpdateService {
    <T extends AbstractEntity> void update(T entity);

    default <T extends AbstractEntity> void update(@Nonnull List<T> entities){
        entities.forEach(this::update);
    }
}
