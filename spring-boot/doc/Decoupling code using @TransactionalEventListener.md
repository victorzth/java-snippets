# Decoupling code using `@TransactionalEventListener`

The `@TransactionalEventListener` is an annotation provided by the Spring framework that allows you to define 
transactional event listener methods. These methods will listen for specific events and execute the corresponding 
operations after the transaction is successfully completed. Using `@TransactionalEventListener` can help you decouple 
your code by separating transactional operations from business logic, thereby improving code maintainability and 
testability.

Here's an example of using @TransactionalEventListener:

* Define an event [ArticleCreated.java](../src/main/java/com/akira/snippets/springboot/event/ArticleCreated.java)

```java
public record ArticleCreated(Integer id) {
}
```

* Publish event when article is created in [ArticleServiceImpl.java](../src/main/java/com/akira/snippets/springboot/service/impl/ArticleServiceImpl.java)

```java
@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ApplicationEventPublisher eventPublisher;
    // other dependencies
    // ...

    @Override
    @Transactional
    public Article save(ArticleAO articleAO) {
        // some logic to save article and author if not exists
        // ...
        
        // publish event after article is created
        eventPublisher.publishEvent(new ArticleCreated(article.getId()));
        return article;
    }
}
```

* Define event listener [ArticleEventListener.java](../src/main/java/com/akira/snippets/springboot/listener/ArticleEventListener.java)

```java
@Component
@RequiredArgsConstructor
public class ArticleEventListener {
    private final ArticleRepository articleRepository;

    // By default, the listener method will be executed synchronously, that means you have to wait until the listener method is completed.
    // If you want to execute the listener method asynchronously, you can use the @Async annotation.
    @Async
    @TransactionalEventListener
    public void handleArticleCreated(ArticleCreated event) {
        // do extra logic
        // ...
        log.info("Article created: {}", articleRepository.findById(event.id()).orElseThrow());
    }
}
```

* The listener method will be triggered after the transaction is successfully completed, you can open transaction log as below:

```yaml
logging:
  level:
    # This is used to trace the opening and closing of transactions
    org.springframework.transaction: trace
```

* then you see the `ArticleEventListener#handleArticleCreated` executed after the transaction is successfully completed:

```
2024-05-02T16:04:33.817+08:00 TRACE 44878 --- [app] [nio-8080-exec-1] o.s.t.i.TransactionInterceptor           : Getting transaction for [com.akira.snippets.springboot.service.impl.ArticleServiceImpl.save]
...
2024-05-02T16:04:33.894+08:00 TRACE 44878 --- [app] [nio-8080-exec-1] o.s.t.i.TransactionInterceptor           : Completing transaction for [com.akira.snippets.springboot.service.impl.ArticleServiceImpl.save]
...
2024-05-02T16:04:38.923+08:00  INFO 44878 --- [app] [         task-1] c.a.s.s.listener.ArticleEventListener    : Article created: Article(id=1, title=My first article, content=This is my first article. It's not very long, but it's a start., author=Author(id=1, name=Victor))
```