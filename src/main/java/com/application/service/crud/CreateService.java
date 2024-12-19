package com.application.service.crud;

import com.application.entity.AbstractEntity;

import java.util.List;

public interface CreateService<T extends AbstractEntity> {
     T create(T entity);

     default void create(List<T> entities){
         entities.forEach(this::create);
     }
}
