package com.github.mertdeveci.service.lock;

import com.github.mertdeveci.cache.LockSource;

public interface LockService {
    void lock(String key);
    void lock(LockSource source, String key);
    void unlock(String key);
    void unlock(LockSource source, String key);
}
