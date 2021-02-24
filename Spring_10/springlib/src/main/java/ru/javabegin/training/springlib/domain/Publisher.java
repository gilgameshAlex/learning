package ru.javabegin.training.springlib.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "publisher", catalog = "learninspring")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Getter @Setter
@EqualsAndHashCode(of = "id")

public class Publisher {
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private String name;

    @Basic(fetch = FetchType.LAZY)
    @OneToMany
    private List<Book> books;

    @Override
    public String toString() {
        return name;
    }
}
