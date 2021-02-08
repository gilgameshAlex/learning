package ru.javabegin.training.springlib.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import ru.javabegin.training.springlib.dao.GenreDao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genre", catalog = "learninspring")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
@Getter @Setter
@EqualsAndHashCode(of = "id")
public class Genre implements GenreDao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private String name;

    @Basic(fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "genre")
    private List<Book> books;

    @Override
    public String toString() {
        return name;
    }

    @Override
    public List<Genre> getAll() {
        return null;
    }

    @Override
    public Genre get(long id) {
        return null;
    }

    @Override
    public Genre save(Genre obj) {
        return null;
    }

    @Override
    public void delete(Genre obj) {

    }

    @Override
    public List<Genre> search(String... searchStr) {
        return null;
    }
}
