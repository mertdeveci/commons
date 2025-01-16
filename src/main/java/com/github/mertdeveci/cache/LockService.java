package com.github.mertdeveci.cache;

import java.time.Duration;

public interface LockService {
    <T extends LockSettings> void lock(T lockType, String key, Duration duration);
    <T extends LockSettings> void unlock(T lockType, String key, Duration duration);

    default <T extends LockSettings> String generateKey(T lockType, String key){
        return lockType.getLockName() + ":" + key;
    }

    default <T extends LockSettings> void lock(T lockType, String key){
        lock(lockType, key, lockType.getTTLUnit().toChronoUnit().getDuration());
    }

    default <T extends LockSettings> void unlock(T lockType, String key){
        unlock(lockType, key, lockType.getTTLUnit().toChronoUnit().getDuration());
    }
}
