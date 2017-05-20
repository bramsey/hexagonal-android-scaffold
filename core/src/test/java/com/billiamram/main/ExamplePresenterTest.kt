package com.billiamram.main

import com.nhaarman.mockito_kotlin.KArgumentCaptor
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.mock
import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.verify
import javax.inject.Inject

class ExamplePresenterTest {

    internal lateinit var view: ExampleView
    internal lateinit var captor: KArgumentCaptor<List<ExampleModel>>

    @Inject internal lateinit var mExampleModelRepository: ExampleModelRepository

    internal lateinit var subject: ExamplePresenter

    @Before
    fun setUp() {
        view = mock()
        captor = argumentCaptor()
        DaggerTestComponent.builder().build().inject(this)

        subject = ExamplePresenter(mExampleModelRepository)
    }

    @Test
    fun loadView_displaysItemsOnView() {
        val expectedItem = ExampleModel(name = "name", value = "val")
        mExampleModelRepository.save(expectedItem)

        subject.loadView(view)

        verify(view).loadItems(captor.capture())
        val actualExampleModels = captor.firstValue
        Assertions.assertThat(actualExampleModels).containsExactly(expectedItem)
    }

}