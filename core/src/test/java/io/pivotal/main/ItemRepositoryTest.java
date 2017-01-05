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

        subject.save(ImmutableItem.builder().name("name1").val("val1").build());
        subject.save(ImmutableItem.builder().name("name2").val("val2").build());

        assertThat(subject.findAll().get(0).getName()).isEqualTo("name1");
        assertThat(subject.findAll().get(1).getName()).isEqualTo("name2");

        assertThat(subject.findAll().get(0).getVal()).isEqualTo("val1");
        assertThat(subject.findAll().get(1).getVal()).isEqualTo("val2");
    }
}