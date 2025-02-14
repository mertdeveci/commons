package com.github.mertdeveci.vo;

import com.github.mertdeveci.converter.mapper.EntityMapper;
import com.github.mertdeveci.entity.AbstractEntity;

public abstract class BaseVo {
    private final BaseVo baseVo;
    private final EntityMapper<AbstractEntity, BaseVo> entityMapper;

    protected BaseVo(BaseVo baseVo, EntityMapper<AbstractEntity, BaseVo> entityMapper) {
        this.baseVo = baseVo;
        this.entityMapper = entityMapper;
    }

    public BaseVo getBaseVo() {
        return baseVo;
    }

    public EntityMapper<AbstractEntity, BaseVo> getEntityMapper() {
        return entityMapper;
    }
}
