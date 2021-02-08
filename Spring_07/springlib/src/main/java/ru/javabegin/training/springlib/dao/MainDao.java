package ru.javabegin.training.springlib.dao;

import java.util.List;

public interface MainDao<T> {
    List<T> getAll();
    T get(long id);
    T save(T obj);
    void delete(T obj);

    List<T> search(String... searchStr);
}
