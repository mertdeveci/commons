package com.application.entity;

import com.application.enums.EntityStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractStatusEntity extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EntityStatus entityStatus;
}
