package io.pivotal.main;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class ItemRepositoryTest {

    private ItemRepository subject;

    public abstract ItemRepository getRepository();

    @Before
    public void setUp() {
        subject = getRepository();
    }

    @Test
    public void savesAndFindsItems() {
        assertThat(subject.findAll()).isEmpty();

        ImmutableItem item1 = ImmutableItem.builder().name("name1").val("val1").build();
        ImmutableItem item2 = ImmutableItem.builder().name("name2").val("val2").build();

        subject.save(item1);
        subject.save(item2);

        assertThat(subject.findAll()).containsExactly(item1, item2);
    }
}