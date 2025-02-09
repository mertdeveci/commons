package com.github.mertdeveci.converter;

import com.github.mertdeveci.entity.AbstractEntity;

import java.util.function.Consumer;

public interface EntityMapper<T, E extends AbstractEntity> {
    T toVo(Consumer<E> entity);
    E toEntity(T entity);
}
