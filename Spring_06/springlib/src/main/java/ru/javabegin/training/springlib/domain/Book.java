package ru.javabegin.training.springlib.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
@Table(name = "book", catalog = "learninspring")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Getter @Setter
@EqualsAndHashCode (of = "id")
public class Book {

    public Book() {
    }

    public Book(long id, String name, Integer pageCount, String isbn, Genre genre, Author author, Integer publishYear, Publisher publisher, Integer avgRating, long totalVoteCount, long totalRating, long viewCount, String description) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.genre = genre;
        this.author = author;
        this.publishYear = publishYear;
        this.publisher = publisher;
        this.avgRating = avgRating;
        this.totalVoteCount = totalVoteCount;
        this.totalRating = totalRating;
        this.viewCount = viewCount;
        this.description = description;
    }

    public Book(long id, byte[] image) {
        this.id = id;
        this.image = image;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private String name;

    @Lob
    private byte[] content;

    @Column(name = "page_count")
    private Integer pageCount;

    private String isbn;

    @ManyToOne
    @JoinColumn
    private Genre genre;

    @ManyToOne
    @JoinColumn
    private Author author;

    @Column(name = "publish_year")
    private Integer publishYear;

    @ManyToOne
    @JoinColumn
    private Publisher publisher;

    @Lob
    private byte[] image;

    @Column(name = "avg_rating")
    private Integer avgRating;

    @Column(name = "total_vote_count")
    private long totalVoteCount;

    @Column(name = "total_rating")
    private long totalRating;

    @Column(name = "view_count")
    private long viewCount;

    @Column(name = "descr")
    private String description;
}
