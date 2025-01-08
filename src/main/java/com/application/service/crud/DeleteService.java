package com.application.service.crud;

import com.application.entity.AbstractEntity;
import jakarta.annotation.Nonnull;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DeleteService<T extends AbstractEntity> {
    void delete(T entity); // add soft delete

    @Transactional
    default void delete(@Nonnull List<T> entities){
        entities.forEach(this::delete);
    }
}
