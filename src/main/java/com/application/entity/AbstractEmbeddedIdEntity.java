package com.application.entity;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class AbstractEmbeddedIdEntity<T> extends AbstractEntity {

    @EmbeddedId
    private T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
