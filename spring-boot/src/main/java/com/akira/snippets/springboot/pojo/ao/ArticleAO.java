package com.akira.snippets.springboot.pojo.ao;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record ArticleAO(
        @NotBlank @Length(max = 100) String title,
        @NotBlank String content,
        @Valid @NotNull AuthorAO author
) {
}
