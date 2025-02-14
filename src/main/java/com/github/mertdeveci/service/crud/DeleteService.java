package com.github.mertdeveci.service.crud;

import com.github.mertdeveci.entity.AbstractStatusEntity;
import com.github.mertdeveci.service.BaseEntityService;
import jakarta.annotation.Nonnull;

import java.util.List;
import java.util.function.Supplier;

public interface DeleteService<T extends AbstractStatusEntity> extends BaseEntityService {
    void deleteById(long id);

    default void delete(@Nonnull List<T> entities){
        entities.forEach(this::delete);
    }

    default <K> void deleteAndThen(@Nonnull List<T> entities, Supplier<K> supplier){
        entities.forEach(this::delete);
        supplier.get();
    }

    default <K> K deleteAndThenGet(@Nonnull List<T> entities, Supplier<K> supplier){
        entities.forEach(this::delete);
        return supplier.get();
    }

}
