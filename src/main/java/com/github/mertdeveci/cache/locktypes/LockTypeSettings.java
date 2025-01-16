package com.github.mertdeveci.cache.locktypes;

import java.util.concurrent.TimeUnit;

public interface LockTypeSettings {
    String getLockName();
    default Long getTTL(){ return 15L; }
    default String getLockErrorMessage(){ return "Lock is already acquired"; }
    default TimeUnit getTTLUnit(){ return TimeUnit.SECONDS; }
}
