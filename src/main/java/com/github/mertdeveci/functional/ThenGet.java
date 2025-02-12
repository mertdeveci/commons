package com.github.mertdeveci.functional;

@FunctionalInterface
public interface ThenGet<T, K> {
    K applyAndRetrieve(T then);
}
