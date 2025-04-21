package com.api.planeje.annotation.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

import com.api.planeje.annotation.entity.Annotation;

@Repository
public interface AnnotationRepository extends JpaRepository<Annotation, Integer>{

    @NativeQuery(value = "select * from annotation where title like CONCAT('%', :title, '%')")
    List<Annotation> filterAnnotationTitle(String title);

    @NativeQuery(value = "select * from annotation where id = :id")
    Annotation getAnnotationById(Integer id);
}


