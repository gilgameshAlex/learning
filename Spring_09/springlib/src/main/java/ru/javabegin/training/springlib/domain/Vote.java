package ru.javabegin.training.springlib.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
@Table(name = "vote", catalog = "learninspring")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
@Getter @Setter
@EqualsAndHashCode(of = "id")
public class Vote {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private Integer value;

    @Column(name = "book_id")
    private long bookId;

    private String username;
}
