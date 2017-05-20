package com.billiamram.main

interface ExampleModelRepository {
    fun findAll(): List<ExampleModel>

    fun save(exampleModel: ExampleModel)
}
