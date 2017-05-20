package com.billiamram.hexagonalscaffold

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.billiamram.main.ExampleModel
import com.billiamram.main.ExamplePresenter
import com.billiamram.main.ExampleView
import javax.inject.Inject

class ExampleActivity : AppCompatActivity(), ExampleView {

    @Inject lateinit var mExamplePresenter: ExamplePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Injector.get(this).inject(this)

        mExamplePresenter.loadView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mExamplePresenter.unloadView()
    }

    override fun loadItems(exampleModels: List<ExampleModel>) {
        exampleModels
                .map { "${it.name}: ${it.value}" }
                .forEach { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() }
    }
}
