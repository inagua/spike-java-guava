package ch.inagua.spike.java.guava.optional;

import com.google.common.base.Optional;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * <code>
 *     - Optional.absent()
 *     - Optional.of
 *     - Optional.fromNullable
 * </code>
 */
public class OptionalTest {

    @Test
    public void test_isPresent() {
        assertTrue(Optional.of("Name of the captain").isPresent());

        assertFalse(Optional.absent().isPresent());

        String name = "Name of the captain";
        assertTrue(Optional.fromNullable(name).isPresent());
        name = null;
        assertFalse(Optional.fromNullable(name).isPresent());
    }

    @Test(expected = NullPointerException.class)
    public void test_of_whileNull() {
        Optional.of(null);
    }

    @Test
    public void test_get() {
        assertThat(Optional.of("Name of the captain").get(), equalTo("Name of the captain"));

        String name = "Name of the captain";
        assertThat(Optional.fromNullable(name).get(), equalTo("Name of the captain"));
    }

    @Test(expected = IllegalStateException.class)
    public void test_get_whileAbsent() {
        Optional.absent().get();
    }

    @Test(expected = IllegalStateException.class)
    public void test_get_whileNull() {
        String name = null;
        Optional.fromNullable(name).get();
    }

    @Test
    public void test_or() {
        assertThat(Optional.of("toto").or("default"), equalTo("toto"));

        Optional<String> absent = Optional.absent();
        assertThat(absent.or("default"), equalTo("default"));
        assertThat(absent.orNull(), is(nullValue()));
    }
}
