package com.github.mertdeveci.service.lock;

import com.github.mertdeveci.cache.LockType;
import java.time.Duration;

public interface LockService {
    <T extends LockType> void lock(T lockType, String key, Duration duration);
    <T extends LockType> void unlock(T lockType, String key, Duration duration);

    default <T extends LockType> String generateKey(T lockType, String key){
        return lockType.getLockName() + ":" + key;
    }

    default <T extends LockType> void lock(T lockType, String key){
        lock(lockType, key, lockType.getTTLUnit().toChronoUnit().getDuration());
    }

    default <T extends LockType> void unlock(T lockType, String key){
        unlock(lockType, key, lockType.getTTLUnit().toChronoUnit().getDuration());
    }
}
