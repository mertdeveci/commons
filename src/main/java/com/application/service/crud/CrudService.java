package com.application.service.crud;

import com.application.entity.AbstractEntity;

public interface CrudService<ID, T extends AbstractEntity>
        extends CreateService<T>, RetrieveService<ID, T>, UpdateService<T>, DeleteService<T> {
}
