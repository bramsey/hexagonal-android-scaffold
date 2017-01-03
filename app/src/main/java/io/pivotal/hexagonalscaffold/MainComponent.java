package io.pivotal.hexagonalscaffold;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MainModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
