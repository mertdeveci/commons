package com.github.mertdeveci.manager;

import com.github.mertdeveci.model.Request;

public interface CrudManager {
    <T extends Request> T create(T request);
    <T extends Request> T retrieve(T request);
    <T extends Request> T update(T request);
    <T extends Request> T delete(T request);
}
