package com.api.planeje.revision.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.api.planeje.revision.entity.Revision;

import jakarta.transaction.Transactional;

@Repository
public interface RevisionRepository extends JpaRepository<Revision, Integer> {

    @NativeQuery(value = "select * from revision where title like CONCAT('%', :title, '%')")
    List<Revision> filterRevisionTitle(String title);

    @NativeQuery(value = "select * from revision where disable = 0")
    @Override
    List<Revision> findAll();

    @NativeQuery(value = "select * from revision where id = :id")
    Revision getRevisionById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "update revision set disable = :disable where id = :id", nativeQuery = true)
    Integer updateRevisionById(@Param("disable") Integer disable, @Param("id") Integer id);

    @NativeQuery(value = "select id from revision order by id desc limit 1")
    Integer lastId();
}