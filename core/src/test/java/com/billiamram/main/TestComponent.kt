package com.billiamram.main

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(TestAdaptersModule::class, CoreModule::class))
interface TestComponent {
    fun inject(examplePresenterTest: ExamplePresenterTest)
}
