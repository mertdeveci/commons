package com.github.mertdeveci.service.crud;

import com.github.mertdeveci.converter.Converter;
import com.github.mertdeveci.converter.mapper.EntityMapper;
import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.functional.ThenGet;
import com.github.mertdeveci.service.BaseEntityService;
import jakarta.annotation.Nonnull;

import java.util.List;
import java.util.function.Consumer;

public interface CreateService<T extends AbstractEntity> extends BaseEntityService {
    default T create(T entity){
        return save(entity);
    }

    default void create(@Nonnull List<T> entities){
         entities.forEach(this::create);
     }

     default <V> T mapAndCreate(V entityVo, EntityMapper<T,V> entityMapper){
        T entity = entityMapper.toEntity(entityVo);
        return create(entity);
     }

    default void createAndThen(T entity, Consumer<T> consumer){
        T t = create(entity);
        consumer.accept(t);
    }

    default <V> void mapAndCreateAndThen(V entityVo, EntityMapper<T,V> entityMapper, Consumer<T> consumer){
        T entity = entityMapper.toEntity(entityVo);
        T t = create(entity);
        consumer.accept(t);
    }

    default <K> K createAndThenGet(T entity, ThenGet<T,K> thenGet){
        T t = create(entity);
        return thenGet.applyAndRetrieve(t);
    }

    default <V,K> K mapAndCreateAndThenGet(V entityVo, EntityMapper<T,V> entityMapper, ThenGet<T,K> thenGet){
        T entity = entityMapper.toEntity(entityVo);
        T t = create(entity);
        return thenGet.applyAndRetrieve(t);
    }

    default <K, R> R createAndThenGetAndMap(T entity, ThenGet<T,K> thenGet, Converter<K, R> converter){
        T t = create(entity);
        K k = thenGet.applyAndRetrieve(t);
        return converter.convert(k);
    }

    default <V> void createAndMapAndThen(V entityVo, EntityMapper<T,V> entityMapper, Consumer<T> then){
        T t = mapAndCreate(entityVo, entityMapper);
        then.accept(t);
    }

    default <V, K> K createAndMapAndThenGet(V entityVo, EntityMapper<T,V> entityMapper, ThenGet<T, K> thenGet){
        T t = mapAndCreate(entityVo, entityMapper);
        return thenGet.applyAndRetrieve(t);
    }
}
