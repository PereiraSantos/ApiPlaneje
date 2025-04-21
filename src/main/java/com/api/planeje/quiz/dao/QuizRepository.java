package com.api.planeje.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

import com.api.planeje.quiz.entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {

    @NativeQuery(value = "select * from quiz where topic like CONCAT('%', :topic, '%')")
    List<Quiz> filterQuizTitle(String topic);

    @NativeQuery(value = "select * from quiz where id = :id")
    Quiz getQuizById(Integer id);
}