package com.api.planeje.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.planeje.ResponseDto;
import com.api.planeje.quiz.entity.Quiz;
import com.api.planeje.quiz.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping()
    public @ResponseBody List<Quiz> GetQuiz() {
        return quizService.GetQuiz();
    }

    @PostMapping()
    public @ResponseBody ResponseEntity<ResponseDto> saveQuiz(@RequestBody Quiz body) {
        return quizService.saveQuiz(body);
    }

    @PostMapping("update")
    public @ResponseBody String updateQuizById(@RequestBody Quiz body) {
        return quizService.updateQuizById(body);
    }

    @GetMapping("/{id}")
    public @ResponseBody Quiz getQuizById(@PathVariable String id) {
        return quizService.getQuizById(Integer.valueOf(id));
    }

    @GetMapping("/search")
    public @ResponseBody Iterable<Quiz> filterQuizTitle(@RequestParam(value = "title") String title) {
        return quizService.filterQuizTitle(title);
    }

}
