package com.api.planeje.annotation.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.api.planeje.annotation.entity.Annotation;

import jakarta.transaction.Transactional;


@Repository
public interface AnnotationRepository extends JpaRepository<Annotation, Integer>{

    @NativeQuery(value = "select * from annotation where title like CONCAT('%', :title, '%')")
    List<Annotation> filterAnnotationTitle(String title);

    @NativeQuery(value = "select * from annotation where disable = 0")
    @Override
    List<Annotation> findAll();

    @NativeQuery(value = "select * from annotation where id = :id")
    Annotation getAnnotationById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "update annotation SET disable = :disable WHERE id = :id", nativeQuery = true)
    Integer updateAnnotationById(@Param("disable") Integer disable, @Param("id") Integer id);

    @NativeQuery(value = "select id from annotation order by id desc limit 1")
    Integer lastId();
}


