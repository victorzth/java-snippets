package com.akria.snippets.springboot;

import com.akira.snippets.springboot.App;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = App.class)
@ActiveProfiles("it")
class AppTest {
    @Test
    void loadContext() {
        Assertions.assertTrue(true);
    }
}
