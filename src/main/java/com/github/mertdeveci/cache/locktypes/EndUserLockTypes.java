package com.github.mertdeveci.cache.locktypes;

import com.github.mertdeveci.cache.LockSettings;

public enum EndUserLockTypes implements LockSettings {
    REGISTRATION{
        @Override
        public String getLockName() {
            return LOCK_NAME + "-" + this.name();
        }

        @Override
        public String getLockErrorMessage() {
            return "Registration is already in progress";
        }

        @Override
        public Long getTTL() {
            return 5L;
        }
    };

    private static final String LOCK_NAME = "END-USER-PROCESS";
}
