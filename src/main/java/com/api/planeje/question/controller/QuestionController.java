package com.api.planeje.question.controller;

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

import com.api.planeje.question.entity.Question;
import com.api.planeje.question.service.QuestionService;


@RestController
@RequestMapping("/question")
public class QuestionController {
    
    @Autowired
    private QuestionService questionService;

    @GetMapping()
    public @ResponseBody List<Question> GetQuestion() {
        return questionService.GetQuestion();
    }

    @PostMapping()
    public @ResponseBody String saveQuestion(@RequestBody Question body) {
        return questionService.saveQuestion(body);
    }

    @GetMapping("/{id}")
    public @ResponseBody Question getQuestionById(@PathVariable String id) {
        return questionService.getQuestionById(Integer.valueOf(id));
    }

    @GetMapping("/search")
    public @ResponseBody Iterable<Question> filterQuestionTitle(@RequestParam(value = "title") String title) {
        return questionService.filterQuestionTitle(title);
    }

}
