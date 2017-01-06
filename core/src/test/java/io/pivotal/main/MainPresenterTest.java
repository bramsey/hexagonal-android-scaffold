package io.pivotal.main;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@SuppressWarnings("WeakerAccess")
@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock MainView view;
    @Captor ArgumentCaptor<List<Item>> captor;

    @Inject ItemRepository itemRepository;

    MainPresenter subject;

    @Before
    public void setUp() {
        DaggerTestComponent.builder().build().inject(this);
        subject = new MainPresenter(itemRepository);
    }

    @Test
    public void loadView_displaysItemsOnView() {
        ImmutableItem expectedItem = ImmutableItem.builder()
                .name("name")
                .val("val")
                .build();
        itemRepository.save(expectedItem);

        subject.loadView(view);

        verify(view).loadItems(captor.capture());
        List<Item> actualItems = captor.getValue();
        assertThat(actualItems).containsExactly(expectedItem);
    }

}