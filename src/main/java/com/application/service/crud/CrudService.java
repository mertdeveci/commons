package com.application.service.crud;

import com.application.entity.AbstractEntity;

public interface CrudService<T extends AbstractEntity, ID>
        extends CreateService<T>, RetrieveService<T, ID>, UpdateService<T>, DeleteService<T> {
}
