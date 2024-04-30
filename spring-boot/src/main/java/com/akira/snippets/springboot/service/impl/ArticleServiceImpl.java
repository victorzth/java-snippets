package com.akira.snippets.springboot.service.impl;

import com.akira.snippets.springboot.pojo.ao.ArticleAO;
import com.akira.snippets.springboot.pojo.entity.Article;
import com.akira.snippets.springboot.pojo.entity.Author;
import com.akira.snippets.springboot.repository.ArticleRepository;
import com.akira.snippets.springboot.service.ArticleService;
import com.akira.snippets.springboot.service.AuthorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final AuthorService authorService;

    @Override
    @Transactional
    public Article save(ArticleAO articleAO) {
        Article article = new Article();
        article.setTitle(articleAO.title());
        article.setContent(articleAO.content());
        Author author = authorService.findOrCreate(articleAO.author());
        article.setAuthor(author);
        return articleRepository.save(article);
    }
}
