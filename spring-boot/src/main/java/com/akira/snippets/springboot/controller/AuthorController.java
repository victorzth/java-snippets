package com.akira.snippets.springboot.controller;

import com.akira.snippets.springboot.pojo.entity.Author;
import com.akira.snippets.springboot.pojo.vo.AuthorVO;
import com.akira.snippets.springboot.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/{id}")
    public AuthorVO findById(@PathVariable("id") Integer id) {
        Author author = authorService.findById(id);
        return new AuthorVO(author);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        authorService.deleteById(id);
    }
}
