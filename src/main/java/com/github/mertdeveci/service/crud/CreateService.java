package com.github.mertdeveci.service.crud;

import com.github.mertdeveci.converter.Converter;
import com.github.mertdeveci.converter.mapper.EntityMapper;
import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.functional.Then;
import com.github.mertdeveci.functional.ThenGet;
import jakarta.annotation.Nonnull;

import java.util.List;
import java.util.Objects;

public interface CreateService<T extends AbstractEntity> {
    T create(T entity);

    default void create(@Nonnull List<T> entities){
         entities.forEach(this::create);
     }

     default <V> T mapAndCreate(V entityVo, EntityMapper<T,V> entityMapper){
         T entity = entityMapper.toEntity(entityVo);
         return create(entity);
     }

    default void createAndThen(T entity, Then<T> then){
        T t = create(entity);
        then.apply(t);
    }

    default <K> K createAndThenGet(T entity, ThenGet<T,K> thenGet){
        T t = create(entity);
        return thenGet.applyAndRetrieve(t);
    }

    default <K, R> R createAndThenGetAndMap(T entity, ThenGet<T,K> thenGet, Converter<K, R> converter){
        T t = create(entity);
        K k = thenGet.applyAndRetrieve(t);
        return converter.convert(k);
    }

    default <V> void createAndMapAndThen(V entityVo, EntityMapper<T,V> entityMapper, Then<T> then){
        T t = mapAndCreate(entityVo, entityMapper);
        then.apply(t);
    }

    default <V, K> K createAndMapAndThenGet(V entityVo, EntityMapper<T,V> entityMapper, ThenGet<T, K> thenGet){
        T t = mapAndCreate(entityVo, entityMapper);
        return thenGet.applyAndRetrieve(t);
    }
}
