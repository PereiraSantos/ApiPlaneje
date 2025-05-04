package com.api.planeje.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.planeje.quiz.dao.QuizRepository;
import com.api.planeje.quiz.entity.Quiz;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public List<Quiz> GetQuiz() {
        return quizRepository.findAll();
    }

    public String saveQuiz(Quiz body) {
        Quiz revision = new Quiz();
        revision.setTopic(body.getTopic());
        revision.setDescription(body.getDescription());

        quizRepository.save(revision);
        return "Salvo com succeso!!!";
    }

    public Quiz getQuizById(Integer id) {
        return quizRepository.getQuizById(id);
    }

    public List<Quiz> filterQuizTitle(String title) {
        return quizRepository.filterQuizTitle(title);
    }
}
