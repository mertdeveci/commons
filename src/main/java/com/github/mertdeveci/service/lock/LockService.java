package com.github.mertdeveci.service.lock;

import com.github.mertdeveci.cache.LockSource;
import java.time.Duration;

public interface LockService {
    <T extends LockSource> void lock(LockSource source, String key);
    <T extends LockSource> void lock(LockSource source, String key, Duration duration);
    <T extends LockSource> void unlock(LockSource source, String key);
    <T extends LockSource> void unlock(LockSource source, String key, Duration);
}
