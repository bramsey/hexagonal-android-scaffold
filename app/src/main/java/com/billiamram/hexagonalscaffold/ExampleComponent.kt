package com.billiamram.hexagonalscaffold

import com.billiamram.main.CoreModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidModule::class, AndroidAdaptersModule::class, CoreModule::class))
interface ExampleComponent {
    fun inject(exampleActivity: ExampleActivity)
}
