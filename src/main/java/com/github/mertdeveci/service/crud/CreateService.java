package com.github.mertdeveci.service.crud;

import com.github.mertdeveci.converter.mapper.EntityMapper;
import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.service.EntityService;
import jakarta.annotation.Nonnull;

import java.util.List;
import java.util.Objects;

public interface CreateService<T extends AbstractEntity> extends EntityService {
    T create(T entity);

    default void create(@Nonnull List<T> entities){
         entities.forEach(this::create);
     }

     default <V> T createAndGet(V entityVo, EntityMapper<V, T> entityMapper){
         T entity = entityMapper.toEntity(entityVo);
         return Objects.isNull(entity) ? null : create(entity);
     }
}
