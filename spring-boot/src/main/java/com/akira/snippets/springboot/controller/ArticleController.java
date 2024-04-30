package com.akira.snippets.springboot.controller;

import com.akira.snippets.springboot.pojo.ao.ArticleAO;
import com.akira.snippets.springboot.pojo.dto.ArticleDTO;
import com.akira.snippets.springboot.repository.ArticleRepository;
import com.akira.snippets.springboot.service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleRepository articleRepository;
    private final ArticleService articleService;

    @GetMapping
    public List<ArticleDTO> findAll() {
        return articleRepository.findAll().stream().map(ArticleDTO::new).toList();
    }

    @PostMapping
    public ArticleDTO save(@Valid @RequestBody ArticleAO articleAO) {
        return new ArticleDTO(articleService.save(articleAO));
    }
}
