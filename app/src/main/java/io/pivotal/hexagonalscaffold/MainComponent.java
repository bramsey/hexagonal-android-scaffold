package io.pivotal.hexagonalscaffold;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AndroidModule.class, MainModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
