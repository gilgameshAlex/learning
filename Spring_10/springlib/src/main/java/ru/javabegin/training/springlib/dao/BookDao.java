package ru.javabegin.training.springlib.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import ru.javabegin.training.springlib.domain.Book;

import java.util.List;

public interface BookDao extends MainDao<Book>{
    List<Book> findTopBooks(int limit);

    byte[] getContent(long id);

    Page<Book> findByGenre(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, long genreId);

    void updateCountView(long viewCount, long id);

    void updateRating(long total_rating, long totalVoteCount, long avgRating, long id);
}
