package ch.inagua.spike.java.guava.optional;

import com.google.common.base.Optional;

/**
 */
public class Train {

    private final Optional<Long> id;

    public Train(Long id) {
        this.id = Optional.fromNullable(id);
    }

    public Optional<Long> getId() {
        return id;
    }

}
