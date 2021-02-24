package ru.javabegin.training.springlib.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.javabegin.training.springlib.dao.BookDao;
import ru.javabegin.training.springlib.domain.Book;
import ru.javabegin.training.springlib.spring.repository.BookRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService implements BookDao {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findTopBooks(int limit) {
        return bookRepository.findTopBooks(PageRequest.of(1, limit));
    }

    @Override
    public byte[] getContent(long id) {
        return bookRepository.getContent(id);
    }

    @Override
    public Page<Book> findByGenre(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, long genreId) {
        return bookRepository.findByGenre(genreId, PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public void updateCountView(long viewCount, long id) {
        bookRepository.updateViewCount(viewCount, id);
    }

    @Override
    public void updateRating(long total_rating, long totalVoteCount, long avgRating, long id) {
        bookRepository.updateBookRating(total_rating, totalVoteCount, avgRating, id);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAllWithoutContent();
    }

    @Override
    public Book get(long id) {
        return null;
    }

    @Override
    public Book save(Book obj) {
        return bookRepository.save(obj);
    }

    @Override
    public void delete(Book obj) {
        bookRepository.delete(obj);
    }

    @Override
    public List<Book> search(String... searchStr) {
        return bookRepository.findByNameContainingIgnoreCaseOrderByName(searchStr[0]);
    }

    @Override
    public List<Book> getAll(Sort sort) {
        return bookRepository.findAllWithoutContent();
    }

    @Override
    public Page<Book> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return bookRepository.findAllWithoutContent(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public Page<Book> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return null;
    }
}
