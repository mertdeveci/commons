package com.github.mertdeveci.manager;

import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.service.crud.CreateService;
import com.github.mertdeveci.service.crud.DeleteService;
import com.github.mertdeveci.service.crud.RetrieveService;
import com.github.mertdeveci.service.crud.UpdateService;

public interface CrudManager<T extends AbstractEntity>
        extends CreateService<T>, RetrieveService<T>, UpdateService<T>, DeleteService<T> {
}
