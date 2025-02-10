package com.github.mertdeveci.converter.mapper;

import com.github.mertdeveci.entity.AbstractEntity;

public interface EntityMapper<T, E extends AbstractEntity> {
    T toVo(E entity);
    E toEntity(T vo);
}
