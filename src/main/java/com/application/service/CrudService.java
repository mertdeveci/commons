package com.application.service;

import com.application.entity.AbstractEntity;
import com.application.service.crud.CreateService;
import com.application.service.crud.DeleteService;
import com.application.service.crud.RetrieveService;
import com.application.service.crud.UpdateService;

public abstract class CrudService<T extends AbstractEntity, ID>
        implements RetrieveService<T, ID>, CreateService<T>, UpdateService<T>, DeleteService<T> {
}
