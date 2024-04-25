package com.akira.snippets.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FooTest {
    @Test
    void testFoo() {
        Foo.main(new String[] {});
        Assertions.assertTrue(true);
    }
}
