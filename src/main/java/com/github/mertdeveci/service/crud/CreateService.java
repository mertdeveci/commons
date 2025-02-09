package com.github.mertdeveci.service.crud;

import com.github.mertdeveci.converter.EntityMapper;
import com.github.mertdeveci.entity.AbstractEntity;
import jakarta.annotation.Nonnull;

import java.util.List;
import java.util.Objects;

public interface CreateService<T extends AbstractEntity> {
    T create(T entity);

    default void create(@Nonnull List<T> entities){
         entities.forEach(this::create);
     }

     default <V> T createAndGet(V entityVo, EntityMapper<V, T> entityMapper){
         T entity = entityMapper.convert(entityVo);
         return Objects.isNull(entity) ? null : create(entity);
     }
}
