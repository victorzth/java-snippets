package com.akira.snippets.springboot.service;

import com.akira.snippets.springboot.pojo.ao.ArticleAO;
import com.akira.snippets.springboot.pojo.entity.Article;

public interface ArticleService {
    Article save(ArticleAO articleAO);
}
