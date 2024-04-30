package com.akira.snippets.springboot.pojo.vo;

import com.akira.snippets.springboot.pojo.entity.Article;
import com.akira.snippets.springboot.pojo.entity.Author;

import java.util.List;

public record AuthorVO(Integer id, String name, List<Integer> articleIds) {
    public AuthorVO(Author author) {
        this(author.getId(), author.getName(), author.getArticles().stream().map(Article::getId).toList());
    }
}
