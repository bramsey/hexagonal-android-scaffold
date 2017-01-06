package io.pivotal.hexagonalscaffold;

import javax.inject.Singleton;

import dagger.Component;
import io.pivotal.main.CoreModule;

@Singleton
@Component(modules = {
        AndroidModule.class,
        AndroidAdaptersModule.class,
        CoreModule.class
})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
