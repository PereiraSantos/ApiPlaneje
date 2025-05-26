package com.api.planeje.question.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.api.planeje.question.entity.Question;

import jakarta.transaction.Transactional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @NativeQuery(value = "select * from question where description like CONCAT('%', :description, '%')")
    List<Question> filterQuestionTitle(String description);

    @NativeQuery(value = "select * from question where disable = 0")
    @Override
    List<Question> findAll();

    @NativeQuery(value = "select * from question where id = :id")
    Question getQuestionById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "update question set disable = :disable where id = :id", nativeQuery = true)
    Integer updateQuestionById(@Param("disable") Integer disable, @Param("id") Integer id);

    @NativeQuery(value = "select id from question order by id desc limit 1")
    Integer lastId();
}