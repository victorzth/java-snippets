package com.akira.snippets.springboot.pojo.ao;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record AuthorAO(@NotBlank @Length(max = 100) String name) {
}