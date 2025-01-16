package com.github.mertdeveci.service.crud;

import com.github.mertdeveci.entity.AbstractEntity;
import jakarta.annotation.Nonnull;

import java.util.List;

public interface CreateService {
    <T extends AbstractEntity> void create(T entity);

    default <T extends AbstractEntity> void create(@Nonnull List<T> entities){
         entities.forEach(this::create);
     }
}
