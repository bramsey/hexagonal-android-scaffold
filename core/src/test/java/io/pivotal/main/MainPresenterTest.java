package io.pivotal.main;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@SuppressWarnings("WeakerAccess")
@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock MainView view;
    @Captor ArgumentCaptor<List<Item>> captor;

    ItemRepository mItemRepository;

    MainPresenter subject;

    @Before
    public void setUp() {
        mItemRepository = new InMemoryItemRepository();
        subject = new MainPresenter(mItemRepository);
    }

    @Test
    public void loadView_displaysItemsOnView() {
        mItemRepository.save(new Item("name", "val"));

        subject.loadView(view);

        verify(view).loadItems(captor.capture());
        Item actualItem = captor.getValue().get(0);
        assertThat(actualItem.getName()).isEqualTo("name");
        assertThat(actualItem.getVal()).isEqualTo("val");
    }

}