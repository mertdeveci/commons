package com.github.mertdeveci.manager;

import com.github.mertdeveci.entity.AbstractEntity;
import com.github.mertdeveci.model.Request;
import com.github.mertdeveci.model.Response;
import com.github.mertdeveci.service.crud.CreateService;
import com.github.mertdeveci.service.crud.DeleteService;
import com.github.mertdeveci.service.crud.RetrieveService;
import com.github.mertdeveci.service.crud.UpdateService;

public abstract class CrudManager<T extends AbstractEntity> {
    private final RetrieveService<T> retrieveService;
    private final CreateService<T> createService;
    private final UpdateService<T> updateService;
    private final DeleteService<T> deleteService;

    public CrudManager(RetrieveService<T> retrieveService, CreateService<T> createService, UpdateService<T> updateService, DeleteService<T> deleteService) {
        this.retrieveService = retrieveService;
        this.createService = createService;
        this.updateService = updateService;
        this.deleteService = deleteService;
    }

    public abstract <K extends Request, L extends Response> K create(K request);
    public abstract <K extends Request, L extends Response> K retrieve(K request);
    public abstract <K extends Request, L extends Response> K update(K request);
    public abstract <K extends Request, L extends Response> K delete(K request);
}
