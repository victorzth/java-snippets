package com.akira.snippets.springboot.repository;

import com.akira.snippets.springboot.pojo.entity.Author;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Optional<Author> findByName(String name);

    @EntityGraph(attributePaths = "articles")
    Optional<Author> findDetailedById(Integer id);
}
