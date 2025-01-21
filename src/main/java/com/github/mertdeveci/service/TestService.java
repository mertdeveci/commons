package com.github.mertdeveci.service;

import com.github.mertdeveci.entity.AbstractEntity;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TestService {


    public static void func(Supplier<Consumer<String>> supplier) {
        supplier.get().accept("TestService");
    }

    public void test() {

    }
}
