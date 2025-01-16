package com.github.mertdeveci.converter;

import com.github.mertdeveci.entity.AbstractEntity;

public interface EntityMapper<I extends AbstractEntity, O extends Record> extends Mapper<I, O>{
}
