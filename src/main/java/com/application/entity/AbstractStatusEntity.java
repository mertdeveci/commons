package com.application.entity;

import com.application.enums.EntityStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractStatusEntity extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EntityStatus entityStatus;

    public EntityStatus getEntityStatus() {
        return entityStatus;
    }

    public void setEntityStatus(EntityStatus entityStatus) {
        this.entityStatus = entityStatus;
    }
}
