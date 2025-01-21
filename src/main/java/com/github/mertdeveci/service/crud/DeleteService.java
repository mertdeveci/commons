package com.github.mertdeveci.service.crud;

import com.github.mertdeveci.entity.AbstractEntity;
import jakarta.annotation.Nonnull;

import java.util.List;

public interface DeleteService {
    <T extends AbstractEntity> void delete(T entity);

    default <T extends AbstractEntity> void delete(@Nonnull List<T> entities){
        entities.forEach(this::delete);
    }
}
