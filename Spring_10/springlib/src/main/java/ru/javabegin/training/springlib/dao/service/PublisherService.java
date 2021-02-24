package ru.javabegin.training.springlib.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.javabegin.training.springlib.dao.PublisherDao;
import ru.javabegin.training.springlib.domain.Publisher;
import ru.javabegin.training.springlib.spring.repository.PublisherRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PublisherService implements PublisherDao {

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher get(long id) {
        Optional<Publisher> optionalPublisher = publisherRepository.findById(id);
        if (optionalPublisher.isPresent()) {
            return optionalPublisher.get();
        } else {
            return null;
        }
    }

    @Override
    public Publisher save(Publisher obj) {
        return publisherRepository.save(obj);
    }

    @Override
    public void delete(Publisher obj) {
        publisherRepository.delete(obj);
    }

    @Override
    public List<Publisher> search(String... searchStr) {
        return publisherRepository.findByNameContainingIgnoreCaseOrderByName(searchStr[0]);
    }

    @Override
    public List<Publisher> getAll(Sort sort) {
        return publisherRepository.findAll(sort);
    }

    @Override
    public Page<Publisher> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return publisherRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public Page<Publisher> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return publisherRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0], PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }
}
