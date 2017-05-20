package com.billiamram.main;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import javax.inject.Inject;

import static org.mockito.Mockito.verify;

@SuppressWarnings("WeakerAccess")
@RunWith(MockitoJUnitRunner.class)
public class ExamplePresenterTest {

    @Mock ExampleView view;
    @Captor ArgumentCaptor<List<ExampleModel>> captor;

    @Inject ExampleModelRepository mExampleModelRepository;

    ExamplePresenter subject;

    @Before
    public void setUp() {
        DaggerTestComponent.builder().build().inject(this);
        subject = new ExamplePresenter(mExampleModelRepository);
    }

    @Test
    public void loadView_displaysItemsOnView() {
        ImmutableExampleModel expectedItem = ImmutableExampleModel.builder()
                .name("name")
                .val("val")
                .build();
        mExampleModelRepository.save(expectedItem);

        subject.loadView(view);

        verify(view).loadItems(captor.capture());
        List<ExampleModel> actualExampleModels = captor.getValue();
        Assertions.assertThat(actualExampleModels).containsExactly(expectedItem);
    }

}