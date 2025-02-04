package com.github.mertdeveci.manager;

import com.github.mertdeveci.service.crud.CreateService;
import com.github.mertdeveci.service.crud.DeleteService;
import com.github.mertdeveci.service.crud.RetrieveService;
import com.github.mertdeveci.service.crud.UpdateService;

public abstract class CrudManager extends RetrieveService implements CreateService, DeleteService, UpdateService {
    public CrudManager(String defaultErrorMessage) {
        super(defaultErrorMessage);
    }
}
