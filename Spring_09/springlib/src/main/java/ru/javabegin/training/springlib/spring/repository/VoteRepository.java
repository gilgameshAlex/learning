package ru.javabegin.training.springlib.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javabegin.training.springlib.domain.Vote;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    List<Vote> findByBookIdEqualsOrderByValue(Long id);

    Page<Vote> findByBookIdEqualsOrderByValue(Long id, Pageable pageable);
}
