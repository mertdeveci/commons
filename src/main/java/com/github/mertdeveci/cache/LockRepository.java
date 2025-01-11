package com.github.mertdeveci.cache;

import java.util.concurrent.TimeUnit;

public interface LockRepository {
    Integer increment(String key, Long timeout, TimeUnit timeUnit);
    void remove(String key);
    Long getExpireTime(String key);
}
