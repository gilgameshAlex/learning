package ru.javabegin.training.springlib.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import ru.javabegin.training.springlib.dao.AuthorDao;

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
public class Author implements AuthorDao {
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

    @Override
    public List<Author> getAll() {
        return null;
    }

    @Override
    public Author get(long id) {
        return null;
    }

    @Override
    public Author save(Author obj) {
        return null;
    }

    @Override
    public void delete(Author obj) {

    }

    @Override
    public List<Author> search(String... searchStr) {
        return null;
    }
}
