package com.api.planeje.dateRevision.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

import com.api.planeje.dateRevision.entity.DateRevision;

@Repository
public interface DateRevisionRepository extends JpaRepository<DateRevision, Integer> {

    @NativeQuery(value = "select * from date_revision where title like CONCAT('%', :date, '%')")
    List<DateRevision> filterDateRevisionTitle(String date);

    @NativeQuery(value = "select * from date_revision where id = :id")
    DateRevision getDateRevisionById(Integer id);
}