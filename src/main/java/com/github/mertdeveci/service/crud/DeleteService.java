package com.github.mertdeveci.service.crud;

import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.service.EntityService;
import jakarta.annotation.Nonnull;

import java.util.List;

public interface DeleteService<T extends AbstractEntity> extends EntityService {
    void delete(T entity);

    default void delete(@Nonnull List<T> entities){
        entities.forEach(this::delete);
    }
}
