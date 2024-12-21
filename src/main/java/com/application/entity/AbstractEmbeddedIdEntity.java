package com.application.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public abstract class AbstractEmbeddedIdEntity<T> extends AbstractEntity {

    @EmbeddedId
    private T id;
}
