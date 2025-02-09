package com.github.mertdeveci.service.crud;

import com.github.mertdeveci.converter.VoMapper;
import com.github.mertdeveci.entity.AbstractEntity;
import jakarta.annotation.Nonnull;

import java.util.List;

public interface CreateService<T extends AbstractEntity> {
    T create(T entity);

    default void create(@Nonnull List<T> entities){
         entities.forEach(this::create);
     }

     default <R extends Record> R createAndGet(T entity, VoMapper<T, R> entityMapper){
         T created = create(entity);
         return entityMapper.convert(created);
     }
}
