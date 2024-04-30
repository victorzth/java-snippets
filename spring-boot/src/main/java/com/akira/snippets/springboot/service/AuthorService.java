package com.akira.snippets.springboot.service;

import com.akira.snippets.springboot.pojo.ao.AuthorAO;
import com.akira.snippets.springboot.pojo.entity.Author;

public interface AuthorService {
    Author findOrCreate(AuthorAO authorAO);
    Author findById(Integer id);
    void deleteById(Integer id);
}
