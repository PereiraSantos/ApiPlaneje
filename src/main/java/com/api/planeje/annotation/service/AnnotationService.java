package com.api.planeje.annotation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.api.planeje.annotation.dao.AnnotationRepository;
import com.api.planeje.annotation.entity.Annotation;


@Service
public class AnnotationService {

    @Autowired
    private AnnotationRepository annotationRepository;

    public List<Annotation> GetAnnotation() {
        return annotationRepository.findAll();
    }

    public String saveAnnotation(Annotation body) {
        Annotation annotation = new Annotation();

        if (body.getId() != null) annotation.setId(body.getId());

        annotation.setTitle(body.getTitle());
        annotation.setText(body.getText());
        annotation.setDateText(body.getDateText());
        annotation.setIdRevision(body.getIdRevision());

        annotationRepository.save(annotation);
        return body.getId() != null ? "Atualizado com succeso!!!" : "Salvo com succeso!!!";
    }
    

    public Annotation getAnnotationById(Integer id) {
        return annotationRepository.getAnnotationById(id);
    }

    public List<Annotation> filterAnnotationTitle(String title) {
        return annotationRepository.filterAnnotationTitle(title);
    }
}
