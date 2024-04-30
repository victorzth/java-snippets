package com.akira.snippets.springboot.pojo.dto;

import com.akira.snippets.springboot.pojo.entity.Author;

public record AuthorDTO(Integer id, String name) {
    public AuthorDTO(Author author) {
        this(author.getId(), author.getName());
    }
}