package com.api.planeje.revisionTheme.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

import com.api.planeje.revisionTheme.entity.RevisionTheme;

@Repository
public interface RevisionThemeRepository extends JpaRepository<RevisionTheme, Integer>  {

    @NativeQuery(value = "select * from revision where title like CONCAT('%', :title, '%')")
    List<RevisionTheme> filterRevisionThemeTitle(String title);

    @NativeQuery(value = "select * from revision where id = :id")
    RevisionTheme getRevisionThemeById(Integer id);
}
