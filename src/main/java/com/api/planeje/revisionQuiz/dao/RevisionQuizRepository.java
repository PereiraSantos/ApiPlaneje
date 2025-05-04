package com.api.planeje.revisionQuiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

import com.api.planeje.revisionQuiz.entity.RevisionQuiz;

@Repository
public interface RevisionQuizRepository extends JpaRepository<RevisionQuiz, Integer> {

    @NativeQuery(value = "select * from revision_quiz where topic like CONCAT('%', :topic, '%')")
    List<RevisionQuiz> filterRevisionQuizTitle(String topic);

    @NativeQuery(value = "select * from revision_quiz where id = :id")
    RevisionQuiz getRevisionQuizById(Integer id);
}