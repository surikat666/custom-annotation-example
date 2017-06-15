package com.strokova.annotation;

import com.strokova.annotation.util.Async;

@Async
public class PrintAction implements Action {

    public void doSomething() {
        System.out.println(Thread.currentThread().getName() + ": hi Victor!");
    }
}
