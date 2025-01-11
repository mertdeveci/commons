package com.github.mertdeveci.cache;

import java.util.concurrent.TimeUnit;

public interface LockSource {
    String getValue();

    default Long getTTL(){
        return 5L;
    }

    default TimeUnit getTTLUnit(){
        return TimeUnit.SECONDS;
    }
}
