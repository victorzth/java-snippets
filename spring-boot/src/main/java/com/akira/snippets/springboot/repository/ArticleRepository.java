package com.akira.snippets.springboot.repository;

import com.akira.snippets.springboot.pojo.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}