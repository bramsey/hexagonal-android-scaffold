package com.billiamram.hexagonalscaffold;

import android.content.Context;

public class Injector {

    private static ExampleComponent exampleComponent;

    public static ExampleComponent get(Context context) {
        if (exampleComponent == null) {
            exampleComponent = DaggerExampleComponent.builder()
                    .androidModule(new AndroidModule(context))
                    .build();
        }

        return exampleComponent;
    }
}
