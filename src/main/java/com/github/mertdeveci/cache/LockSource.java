package com.github.mertdeveci.cache;

import java.util.concurrent.TimeUnit;

public interface LockSource {
    String getLockName();
    String getLockErrorMessage();

    default String generateKey(String key){
        return getLockName() + ":" + key;
    }

    default Long getTTL(){
        return 5L;
    }

    default TimeUnit getTTLUnit(){
        return TimeUnit.SECONDS;
    }
}
