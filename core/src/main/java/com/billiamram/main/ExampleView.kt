package com.billiamram.main

import com.billiamram.framework.View

interface ExampleView : View {
    fun loadItems(exampleModels: List<ExampleModel>)
}
