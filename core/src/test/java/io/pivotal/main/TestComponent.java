package io.pivotal.main;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TestAdaptersModule.class, CoreModule.class})
public interface TestComponent {
    void inject(ExamplePresenterTest examplePresenterTest);
}
