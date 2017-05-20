package com.billiamram.main

import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test

abstract class ExampleModelRepositoryTest {

    private lateinit var subject: ExampleModelRepository

    abstract val repository: ExampleModelRepository

    @Before
    fun setUp() {
        subject = repository
    }

    @Test
    fun savesAndFindsItems() {
        Assertions.assertThat(subject.findAll()).isEmpty()

        val model1 = ExampleModel(name = "name1", value = "val1")
        val model2 = ExampleModel(name = "name2", value = "val2")

        subject.save(model1)
        subject.save(model2)

        Assertions.assertThat(subject.findAll()).containsExactly(model1, model2)
    }
}