package com.api.planeje.revisionQuiz.controller;

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

import com.api.planeje.revisionQuiz.entity.RevisionQuiz;
import com.api.planeje.revisionQuiz.service.RevisionQuizService;

@RestController
@RequestMapping("/revision-quiz")
public class RevisionQuizController {
    
    @Autowired
    private RevisionQuizService revisionQuizService;

    @GetMapping()
    public @ResponseBody List<RevisionQuiz> GetRevisionQuiz() {
        return revisionQuizService.GetRevisionQuiz();
    }

    @PostMapping()
    public @ResponseBody String saveRevision(@RequestBody RevisionQuiz body) {
        return revisionQuizService.saveRevisionQuiz(body);
    }

    @GetMapping("/{id}")
    public @ResponseBody RevisionQuiz getRevisivionById(@PathVariable String id) {
        return revisionQuizService.getRevisivionQuizById(Integer.valueOf(id));
    }

    @GetMapping("/search")
    public @ResponseBody Iterable<RevisionQuiz> filterRevisionQuizTitle(@RequestParam(value = "title") String title) {
        return revisionQuizService.filterRevisionQuizTitle(title);
    }

}
