package com.application.service.crud;

import com.application.entity.AbstractEntity;
import jakarta.annotation.Nonnull;

import java.util.List;

public interface DeleteService<T extends AbstractEntity> {
    void delete(T entity); // add soft delete

    default void delete(@Nonnull List<T> entities){
        entities.forEach(this::delete);
    }
}
