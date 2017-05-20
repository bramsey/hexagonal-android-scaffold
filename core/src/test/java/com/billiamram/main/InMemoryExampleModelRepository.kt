package com.billiamram.main

import java.util.*

class InMemoryExampleModelRepository : ExampleModelRepository {

    private val mExampleModels = ArrayList<ExampleModel>()

    override fun findAll(): List<ExampleModel> {
        return mExampleModels
    }

    override fun save(exampleModel: ExampleModel) {
        mExampleModels.add(exampleModel)
    }
}
