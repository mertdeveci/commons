package com.github.mertdeveci.converter;

import com.github.mertdeveci.entity.AbstractEntity;

public interface EntityMapper<T, K extends AbstractEntity> extends Mapper<T, K> {
    default K mapToVo(T entity) {
        return this.convert(entity);
    }
}
