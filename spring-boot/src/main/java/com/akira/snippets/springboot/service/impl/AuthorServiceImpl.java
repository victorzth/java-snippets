package com.akira.snippets.springboot.service.impl;

import com.akira.snippets.springboot.pojo.ao.AuthorAO;
import com.akira.snippets.springboot.pojo.entity.Author;
import com.akira.snippets.springboot.repository.AuthorRepository;
import com.akira.snippets.springboot.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public Author findOrCreate(AuthorAO authorAO) {
        Optional<Author> optionalAuthor = authorRepository.findByName(authorAO.name());
        if (optionalAuthor.isPresent()) return optionalAuthor.get();
        Author author = new Author();
        author.setName(authorAO.name());
        return authorRepository.save(author);
    }

    @Override
    public Author findDetailedById(Integer id) {
        return authorRepository.findDetailedById(id).orElseThrow();
    }

    @Override
    public void deleteById(Integer id) {
        authorRepository.deleteById(id);
    }
}
