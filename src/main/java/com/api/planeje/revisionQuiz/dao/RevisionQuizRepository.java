package com.api.planeje.revisionQuiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.planeje.revisionQuiz.entity.RevisionQuiz;

import jakarta.transaction.Transactional;

@Repository
public interface RevisionQuizRepository extends JpaRepository<RevisionQuiz, Integer> {

    @NativeQuery(value = "select * from revision_quiz where topic like CONCAT('%', :topic, '%')")
    List<RevisionQuiz> filterRevisionQuizTitle(String topic);

    @NativeQuery(value = "select * from revision_quiz where disable = 0")
    @Override
    List<RevisionQuiz> findAll();

    @NativeQuery(value = "select * from revision_quiz where id = :id")
    RevisionQuiz getRevisionQuizById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "update revision_quiz set disable = :disable where id = :id", nativeQuery = true)
    Integer updateRevisionQuizById(@Param("disable") Integer disable, @Param("id") Integer id);

    @NativeQuery(value = "select id from revision_quiz order by id desc limit 1")
    Integer lastId();
}