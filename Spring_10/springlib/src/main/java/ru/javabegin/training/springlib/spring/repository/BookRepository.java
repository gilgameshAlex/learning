package ru.javabegin.training.springlib.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.javabegin.training.springlib.domain.Author;
import ru.javabegin.training.springlib.domain.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByNameContainingIgnoreCaseOrderByName(String name);
    List<Book> findByNameContainingIgnoreCaseOrAuthorFioContainingIgnoreCaseOrderByName(String name, String fio);

    @Query("select new ru.javabegin.training.springlib.domain.Book(b.id, b.name, b.pageCount, b.isbn, b.genre, b.author, b.publishYear, b.publisher, b.avgRating, b.totalVoteCount, b.totalRating, b.viewCount, b.description) from Book b")
    Page<Book> findAllWithoutContent(Pageable pageable);

    @Query("select new ru.javabegin.training.springlib.domain.Book(b.id, b.name, b.pageCount, b.isbn, b.genre, b.author, b.publishYear, b.publisher, b.avgRating, b.totalVoteCount, b.totalRating, b.viewCount, b.description) from Book b")
    List<Book> findAllWithoutContent();

    @Modifying(clearAutomatically = true)
    @Query("update Book b set b.content=:content where b.id=:id")
    void updateContent(@Param("content") byte[] content, @Param("id") long id);

    @Query("select new ru.javabegin.training.springlib.domain.Book(b.id, b.image) from Book b")
    List<Book> findTopBooks(Pageable pageable);

    @Query("select new ru.javabegin.training.springlib.domain.Book(b.id, b.name, b.pageCount, b.isbn, b.genre, b.author, b.publishYear, b.publisher, b.avgRating, b.totalVoteCount, b.totalRating, b.viewCount, b.description) from Book b where b.genre.id=:genreId")
    Page<Book> findByGenre(@Param("genreId") long genreId, Pageable pageable);

    @Query("select b.content from Book b where b.id = :id")
    byte[] getContent(@Param("id") long id);

    @Modifying
    @Query("update Book b set b.viewCount=:viewCount where b.id=:id")
    void updateViewCount(@Param("viewCount") long viewCount, @Param("id") long id);

    @Modifying
    @Query("update Book b set b.totalRating=:trat, b.totalVoteCount=:tvcnt, b.avgRating=:arat where b.id=:id")
    void updateBookRating(@Param("trat") long total_rating, @Param("tvcnt") long totalVoteCount, @Param("arat") long avgRating, @Param("id") long id);
}
