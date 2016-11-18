package ch.inagua.spike.java.guava.optional;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 */
public class TrainTest {

    @Test public void test_nullable() throws Exception {

        Long id = 111L;
        assertThat(new Train(id).getId().isPresent(), is(true));
        assertThat(new Train(id).getId().get(), equalTo(111L));

        assertThat(new Train(null).getId().isPresent(), is(false));
        assertThat(new Train(null).getId().or(-1L), equalTo(-1L));

    }
}
