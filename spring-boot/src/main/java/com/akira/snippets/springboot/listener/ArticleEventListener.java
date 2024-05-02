package com.akira.snippets.springboot.listener;

import com.akira.snippets.springboot.event.ArticleCreated;
import com.akira.snippets.springboot.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class ArticleEventListener {
    private final ArticleRepository articleRepository;

    @Async
    @TransactionalEventListener
    public void handleArticleCreated(ArticleCreated event) {
        // sleet 5s for test
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) { // NOSONAR
        }
        log.info("Article created: {}", articleRepository.findById(event.id()).orElseThrow());
    }
}
