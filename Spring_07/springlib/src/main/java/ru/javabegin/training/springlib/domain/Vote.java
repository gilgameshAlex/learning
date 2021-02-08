package ru.javabegin.training.springlib.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import ru.javabegin.training.springlib.dao.VoteDao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vote", catalog = "learninspring")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
@Getter @Setter
@EqualsAndHashCode(of = "id")
public class Vote implements VoteDao {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private Integer value;

    @Column(name = "book_id")
    private long bookId;

    private String username;

    @Override
    public List<Vote> getAll() {
        return null;
    }

    @Override
    public Vote get(long id) {
        return null;
    }

    @Override
    public Vote save(Vote obj) {
        return null;
    }

    @Override
    public void delete(Vote obj) {

    }

    @Override
    public List<Vote> search(String... searchStr) {
        return null;
    }
}
