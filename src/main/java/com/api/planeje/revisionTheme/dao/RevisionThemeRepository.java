package com.api.planeje.revisionTheme.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.planeje.revisionTheme.entity.RevisionTheme;

import jakarta.transaction.Transactional;

@Repository
public interface RevisionThemeRepository extends JpaRepository<RevisionTheme, Integer> {

    @NativeQuery(value = "select * from revision_theme where title like CONCAT('%', :title, '%')")
    List<RevisionTheme> filterRevisionThemeTitle(String title);

    @NativeQuery(value = "select * from revision_theme where disable = 0")
    @Override
    List<RevisionTheme> findAll();

    @NativeQuery(value = "select * from revision_theme where id = :id")
    RevisionTheme getRevisionThemeById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "update revision_theme set disable = :disable where id = :id", nativeQuery = true)
    Integer updateRevisionThemeById(@Param("disable") Integer disable, @Param("id") Integer id);

    @NativeQuery(value = "select id from revision_theme order by id desc limit 1")
    Integer lastId();
}
