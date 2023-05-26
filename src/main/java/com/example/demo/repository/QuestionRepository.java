package com.example.demo.repository;

import com.example.demo.entity.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
//    @Query(value = "SELECT * FROM questions ORDER BY RAND() LIMIT :n", nativeQuery = true)
//    List<Question> findRandomNRecord(@Param("n") int n);
//
//    List<Question> findByIdIn(Collection<Long> id);
}
