package com.github.mertdeveci.service.crud;

import com.github.mertdeveci.converter.mapper.EntityMapper;
import com.github.mertdeveci.entity.AbstractEntity;
import jakarta.annotation.Nonnull;

import java.util.List;
import java.util.function.Supplier;

public interface DeleteService<T extends AbstractEntity> {
    void delete(T entity);

    default void delete(@Nonnull List<T> entities){
        entities.forEach(this::delete);
    }

    default <V> void deleteAndMap(V entityVo, EntityMapper<T,V> entityMapper){
        T entity = entityMapper.toEntity(entityVo);
        delete(entity);
    }

    default <V> void deleteAndMap(List<V> entityVoList, EntityMapper<T,V> entityMapper){
        entityVoList.stream().map(entityMapper::toEntity).forEach(this::delete);
    }

    default <K> K deleteAndThen(@Nonnull List<T> entities, Supplier<K> supplier){
        entities.forEach(this::delete);
        return supplier.get();
    }
}
