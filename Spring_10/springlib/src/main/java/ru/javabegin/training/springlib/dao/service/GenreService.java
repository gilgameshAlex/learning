package ru.javabegin.training.springlib.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.javabegin.training.springlib.dao.GenreDao;
import ru.javabegin.training.springlib.domain.Genre;
import ru.javabegin.training.springlib.spring.repository.GenreRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GenreService implements GenreDao {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre get(long id) {
        Optional<Genre> optionalGenre = genreRepository.findById(id);
        if (optionalGenre.isPresent()) {
            return optionalGenre.get();
        } else {
            return null;
        }
    }

    @Override
    public Genre save(Genre obj) {
        return genreRepository.save(obj);
    }

    @Override
    public void delete(Genre obj) {
        genreRepository.delete(obj);
    }

    @Override
    public List<Genre> search(String... searchStr) {
        return genreRepository.findByNameContainingIgnoreCaseOrderByName(searchStr[0]);
    }

    @Override
    public List<Genre> getAll(Sort sort) {
        return genreRepository.findAll(sort);
    }

    @Override
    public Page<Genre> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return genreRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public Page<Genre> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return genreRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0], PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }
}
