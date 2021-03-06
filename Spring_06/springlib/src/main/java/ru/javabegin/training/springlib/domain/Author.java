package ru.javabegin.training.springlib.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table (name = "author", catalog = "learninspring")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Getter @Setter
@EqualsAndHashCode(of = "id")
public class Author {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private String fio;

    private Date birthday;

    @Basic(fetch = FetchType.LAZY)
    @OneToMany
    private List<Book> books;

    @Override
    public String toString() {
        return fio;
    }
}
