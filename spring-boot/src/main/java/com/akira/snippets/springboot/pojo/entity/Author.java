package com.akira.snippets.springboot.pojo.entity;

import com.akira.snippets.springboot.util.HibernateUtils;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Author", uniqueConstraints = {
        @UniqueConstraint(name = "uni_name", columnNames = "name")
})
@Getter
@Setter
@ToString
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Article> articles;

    @SuppressWarnings("com.intellij.jpb.inspection.EqualsDoesntCheckParameterClassInspection")
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (HibernateUtils.getEffectiveClass(this) != HibernateUtils.getEffectiveClass(o)) return false;
        Author author = (Author) o;
        return getName() != null && Objects.equals(getName(), author.getName());
    }

    @Override
    public final int hashCode() {
        return getName().hashCode();
    }
}
