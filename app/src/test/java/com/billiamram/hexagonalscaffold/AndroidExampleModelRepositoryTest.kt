package com.billiamram.hexagonalscaffold

import com.billiamram.main.ExampleModelRepository
import com.billiamram.main.ExampleModelRepositoryTest
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class AndroidExampleModelRepositoryTest : ExampleModelRepositoryTest() {
    override val repository: ExampleModelRepository
        get() {
            val context = RuntimeEnvironment.application
            val sharedPreferences = context.getSharedPreferences("default", 0)
            return AndroidExampleModelRepository(sharedPreferences, AndroidAdaptersModule().provideGson())
        }
}