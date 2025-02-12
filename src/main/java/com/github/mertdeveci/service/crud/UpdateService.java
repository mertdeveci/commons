package com.github.mertdeveci.service.crud;

import com.github.mertdeveci.converter.mapper.EntityMapper;
import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.functional.Then;
import com.github.mertdeveci.functional.ThenGet;
import jakarta.annotation.Nonnull;

import java.util.List;

public interface UpdateService<T extends AbstractEntity> {
    T update(T entity);

    default void update(@Nonnull List<T> entities){
        entities.forEach(this::update);
    }

    default <V> T mapAndUpdate(V entityVo, EntityMapper<T,V> entityMapper){
        T entity = entityMapper.toEntity(entityVo);
        return update(entity);
    }

    default <V> void mapAndUpdateThen(V entityVo, EntityMapper<T,V> entityMapper, Then<T> then){
        T t = mapAndUpdate(entityVo, entityMapper);
        then.apply(t);
    }

    default <V, K> K mapAndUpdateThenGet(V entityVo, EntityMapper<T,V> entityMapper, ThenGet<T,K> thenGet){
        T t = mapAndUpdate(entityVo, entityMapper);
        return thenGet.applyAndRetrieve(t);
    }

    default void updateAndThen(T entity, Then<T> then){
        T t = update(entity);
        then.apply(t);
    }

    default <R> R updateAndThenGet(T entity, ThenGet<T,R> thenGet){
        T t = update(entity);
        return thenGet.applyAndRetrieve(t);
    }


}
