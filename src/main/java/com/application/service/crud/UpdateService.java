package com.application.service.crud;

import com.application.entity.AbstractEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UpdateService<T extends AbstractEntity> {
    void update(T entity);

    @Transactional
    default void update(List<T> entities){
        entities.forEach(this::update);
    }
}
