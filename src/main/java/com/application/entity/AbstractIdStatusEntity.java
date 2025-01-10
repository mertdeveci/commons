package com.application.entity;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class AbstractIdStatusEntity extends AbstractStatusEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
