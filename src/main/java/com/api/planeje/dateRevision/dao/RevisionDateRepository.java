package com.api.planeje.dateRevision.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.api.planeje.dateRevision.entity.RevisionDate;

import jakarta.transaction.Transactional;

@Repository
public interface RevisionDateRepository extends JpaRepository<RevisionDate, Integer> {

    @NativeQuery(value = "select * from revision_date where title like CONCAT('%', :date, '%')")
    List<RevisionDate> filterDateRevisionTitle(String date);

    @NativeQuery(value = "select * from revision_date where disable = 0")
    @Override
    List<RevisionDate> findAll();

    @NativeQuery(value = "select * from revision_date where id = :id")
    RevisionDate getDateRevisionById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "update revision_date set disable = :disable where id = :id", nativeQuery = true)
    Integer updateDateRevisionById(@Param("disable") Integer disable, @Param("id") Integer id);

    @NativeQuery(value = "select id from revision_date order by id desc limit 1")
    Integer lastId();
}