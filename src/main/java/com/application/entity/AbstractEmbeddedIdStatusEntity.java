package com.application.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public abstract class AbstractEmbeddedIdStatusEntity<T> extends AbstractStatusEntity {

    @EmbeddedId
    private T id;
}
