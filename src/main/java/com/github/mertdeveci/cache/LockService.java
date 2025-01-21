package com.github.mertdeveci.cache;

import com.github.mertdeveci.cache.locktypes.LockTypeSettings;

import java.time.Duration;

public interface LockService {
    void lock(LockTypeSettings lockType, String key, Duration duration);
    void unlock(LockTypeSettings lockType, String key, Duration duration);

    default String generateKey(LockTypeSettings lockType, String key){
        return lockType.getLockName() + ":" + key;
    }

    default void lock(LockTypeSettings lockType, String key){
        lock(lockType, key, lockType.getTTLUnit().toChronoUnit().getDuration());
    }

    default void unlock(LockTypeSettings lockType, String key){
        unlock(lockType, key, lockType.getTTLUnit().toChronoUnit().getDuration());
    }
}
