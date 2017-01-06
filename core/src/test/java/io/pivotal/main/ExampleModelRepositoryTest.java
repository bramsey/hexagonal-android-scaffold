package io.pivotal.main;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class ExampleModelRepositoryTest {

    private ExampleModelRepository subject;

    public abstract ExampleModelRepository getRepository();

    @Before
    public void setUp() {
        subject = getRepository();
    }

    @Test
    public void savesAndFindsItems() {
        assertThat(subject.findAll()).isEmpty();

        ImmutableExampleModel model1 = ImmutableExampleModel.builder().name("name1").val("val1").build();
        ImmutableExampleModel model2 = ImmutableExampleModel.builder().name("name2").val("val2").build();

        subject.save(model1);
        subject.save(model2);

        assertThat(subject.findAll()).containsExactly(model1, model2);
    }
}