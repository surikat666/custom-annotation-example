package com.strokova.annotation;

import com.strokova.annotation.util.ActionRunner;

public class Main {

    public static void main(String[] args) {
        ActionRunner.createActionRunner().run(new PrintAction()).close();
    }
}
