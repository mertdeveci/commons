package com.github.mertdeveci.cache;

import com.github.mertdeveci.cache.locktypes.LockTypeSettings;

import java.time.Duration;

public interface LockService {
    <T extends LockTypeSettings> void lock(T lockType, String key, Duration duration);
    <T extends LockTypeSettings> void unlock(T lockType, String key, Duration duration);

    default <T extends LockTypeSettings> String generateKey(T lockType, String key){
        return lockType.getLockName() + ":" + key;
    }

    default <T extends LockTypeSettings> void lock(T lockType, String key){
        lock(lockType, key, lockType.getTTLUnit().toChronoUnit().getDuration());
    }

    default <T extends LockTypeSettings> void unlock(T lockType, String key){
        unlock(lockType, key, lockType.getTTLUnit().toChronoUnit().getDuration());
    }
}
