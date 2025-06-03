package com.api.planeje.annotation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.planeje.ResponseDto;
import com.api.planeje.annotation.dao.AnnotationRepository;
import com.api.planeje.annotation.entity.Annotation;

@Service
public class AnnotationService {

    @Autowired
    private AnnotationRepository annotationRepository;

    public List<Annotation> GetAnnotation() {
        return annotationRepository.findAll();
    }

    public ResponseEntity<ResponseDto> saveAnnotation(Annotation body) {
        Annotation annotation = new Annotation();

        if (body.getId() != null) {
            annotation.setId(body.getId());
        } else {
            Integer id = annotationRepository.lastId();
            id = id == null ? 1 : id + 1;

            annotation.setId(id);
     
        }

        annotation.setDisable(0);

        annotation.setTitle(body.getTitle());
        annotation.setText(body.getText());
        annotation.setDateText(body.getDateText());
        annotation.setIdRevision(body.getIdRevision());

        annotation = annotationRepository.save(annotation);
        return ResponseEntity.ok().body(new ResponseDto(annotation.getId(),
                body.getId() != null ? "Atualizado com succeso!!!" : "Salvo com succeso!!!"));
    }

    public Annotation getAnnotationById(Integer id) {
        return annotationRepository.getAnnotationById(id);
    }

    public List<Annotation> filterAnnotationTitle(String title) {
        return annotationRepository.filterAnnotationTitle(title);
    }

    public String updateAnnotationById(Annotation body) {
        annotationRepository.updateAnnotationById(body.getDisable(), body.getId());

        return "Atualizado com succeso!!!";
    }
}
