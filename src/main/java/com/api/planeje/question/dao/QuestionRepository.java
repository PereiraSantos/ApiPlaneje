package com.api.planeje.question.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

import com.api.planeje.question.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @NativeQuery(value = "select * from question where description like CONCAT('%', :description, '%')")
    List<Question> filterQuestionTitle(String description);

    @NativeQuery(value = "select * from question where id = :id")
    Question getQuestionById(Integer id);
}