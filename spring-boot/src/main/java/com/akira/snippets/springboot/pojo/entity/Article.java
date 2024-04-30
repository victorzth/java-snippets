package com.akira.snippets.springboot.pojo.entity;

import com.akira.snippets.springboot.util.HibernateUtils;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "Article", indexes = {
        @Index(name = "idx_author_id", columnList = "author_id")
})
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "content", nullable = false, columnDefinition = "text")
    private String content;

    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Author author;

    @SuppressWarnings("com.intellij.jpb.inspection.EqualsDoesntCheckParameterClassInspection")
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (HibernateUtils.getEffectiveClass(this) != HibernateUtils.getEffectiveClass(o)) return false;
        Article article = (Article) o;
        return getId() != null && Objects.equals(getId(), article.getId());
    }

    @Override
    public final int hashCode() {
        return HibernateUtils.getEffectiveClass(this).hashCode();
    }
}
