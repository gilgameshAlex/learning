package ru.javabegin.training.springlib.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import ru.javabegin.training.springlib.dao.PublisherDao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "publisher", catalog = "learninspring")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Getter @Setter
@EqualsAndHashCode(of = "id")

public class Publisher implements PublisherDao {
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

    @Override
    public List<Publisher> getAll() {
        return null;
    }

    @Override
    public Publisher get(long id) {
        return null;
    }

    @Override
    public Publisher save(Publisher obj) {
        return null;
    }

    @Override
    public void delete(Publisher obj) {

    }

    @Override
    public List<Publisher> search(String... searchStr) {
        return null;
    }
}
