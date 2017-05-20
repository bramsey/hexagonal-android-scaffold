package com.billiamram.hexagonalscaffold;

import com.billiamram.main.CoreModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AndroidModule.class,
        AndroidAdaptersModule.class,
        CoreModule.class
})
public interface ExampleComponent {
    void inject(ExampleActivity exampleActivity);
}
