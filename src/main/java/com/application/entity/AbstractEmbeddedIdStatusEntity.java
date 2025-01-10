package com.application.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEmbeddedIdStatusEntity<T> extends AbstractStatusEntity {

    @EmbeddedId
    private T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
