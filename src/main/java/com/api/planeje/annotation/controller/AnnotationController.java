package com.api.planeje.annotation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.planeje.annotation.entity.Annotation;
import com.api.planeje.annotation.service.AnnotationService;

@RestController
@RequestMapping("/annotation")
public class AnnotationController {

    @Autowired
    private AnnotationService annotationService;

    @GetMapping()
    public @ResponseBody List<Annotation> GetAnnotation() {
        return annotationService.GetAnnotation();
    }

    @PostMapping()
    public @ResponseBody String saveAnnotation(@RequestBody Annotation body) {
        return annotationService.saveAnnotation(body);
    }

    @PostMapping("/update")
    public @ResponseBody String updateAnnotationById(@RequestBody Annotation body) {
        return annotationService.updateAnnotationById(body);
    }

    @GetMapping("/{id}")
    public @ResponseBody Annotation getAnnotationById(@PathVariable String id) {
        return annotationService.getAnnotationById(Integer.valueOf(id));
    }

    @GetMapping("/search")
    public @ResponseBody Iterable<Annotation> filterAnnotationTitle(@RequestParam(value = "title") String title) {
        return annotationService.filterAnnotationTitle(title);
    }
}
