package com.api.planeje.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.api.planeje.quiz.entity.Quiz;

import jakarta.transaction.Transactional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {

    @NativeQuery(value = "select * from quiz where topic like CONCAT('%', :topic, '%')")
    List<Quiz> filterQuizTitle(String topic);

    @NativeQuery(value = "select * from quiz where disable = 0")
    @Override
    List<Quiz> findAll();

    @NativeQuery(value = "select * from quiz where id = :id")
    Quiz getQuizById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "update quiz set disable = :disable where id = :id", nativeQuery = true)
    Integer updateQuizById(@Param("disable") Integer disable, @Param("id") Integer id);

    @NativeQuery(value = "select id from quiz order by id desc limit 1")
    Integer lastId();
}