package io.pivotal.hexagonalscaffold;

public class Injector {

    private static MainComponent mainComponent;

    public static MainComponent get() {
        if (mainComponent == null) {
            mainComponent = DaggerMainComponent.builder().build();
        }

        return mainComponent;
    }
}
