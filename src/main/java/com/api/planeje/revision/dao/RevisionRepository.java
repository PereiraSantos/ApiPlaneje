package com.api.planeje.revision.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

import com.api.planeje.revision.entity.Revision;

@Repository
public interface RevisionRepository extends JpaRepository<Revision, Integer> {

    @NativeQuery(value = "select * from revision where title like CONCAT('%', :title, '%')")
    List<Revision> filterRevisionTitle(String title);

    @NativeQuery(value = "select * from revision where id = :id")
    Revision getRevisionById(Integer id);
}