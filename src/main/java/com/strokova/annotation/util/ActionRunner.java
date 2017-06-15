package com.strokova.annotation.util;

import com.strokova.annotation.Action;

import java.util.concurrent.ExecutorService;

import static java.util.Objects.isNull;
import static java.util.concurrent.Executors.newCachedThreadPool;

public class ActionRunner {

    private final ExecutorService threadPool;

    private ActionRunner() {
        this.threadPool = newCachedThreadPool();
    }

    public static ActionRunner createActionRunner() {
        return new ActionRunner();
    }

    public ActionRunner run(Action... actions) {
        for (Action action : actions) {
            Async annotation = action.getClass().getAnnotation(Async.class);
            if (isNull(annotation)) {
                action.doSomething();
            } else {
                threadPool.execute(action::doSomething);
            }
        }
        return this;
    }

    public void close() {
        threadPool.shutdown();
    }


}
