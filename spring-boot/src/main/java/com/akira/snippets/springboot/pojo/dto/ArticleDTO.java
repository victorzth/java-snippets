package com.akira.snippets.springboot.pojo.dto;

import com.akira.snippets.springboot.pojo.entity.Article;

public record ArticleDTO(Integer id, String title, String content, AuthorDTO author) {
    public ArticleDTO(Article article) {
        this(article.getId(), article.getTitle(), article.getContent(), new AuthorDTO(article.getAuthor()));
    }
}