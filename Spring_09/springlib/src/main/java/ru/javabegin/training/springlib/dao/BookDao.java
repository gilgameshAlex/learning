package ru.javabegin.training.springlib.dao;

import ru.javabegin.training.springlib.domain.Book;

import java.util.List;

public interface BookDao extends MainDao<Book>{
    List<Book> findTopBooks(int limit);

    byte[] getContent(long id);
}
