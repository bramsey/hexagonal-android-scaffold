package io.pivotal.hexagonalscaffold;

import android.content.Context;

public class Injector {

    private static MainComponent mainComponent;

    public static MainComponent get(Context context) {
        if (mainComponent == null) {
            mainComponent = DaggerMainComponent.builder()
                    .androidModule(new AndroidModule(context))
                    .build();
        }

        return mainComponent;
    }
}
