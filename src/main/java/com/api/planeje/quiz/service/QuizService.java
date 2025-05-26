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
        Quiz quiz = new Quiz();

        if (body.getId() != null) {
            quiz.setId(body.getId());
        } else {
            Integer id = quizRepository.lastId();
            id = id == null ? 1 : id + 1;

            quiz.setId(id);
            quiz.setDisable(0);
        }

        quiz.setTopic(body.getTopic());
        quiz.setDescription(body.getDescription());

        quizRepository.save(quiz);
        
        return body.getId() != null ? "Atualizado com succeso!!!" : "Salvo com succeso!!!";
    }

    public Quiz getQuizById(Integer id) {
        return quizRepository.getQuizById(id);
    }

    public List<Quiz> filterQuizTitle(String title) {
        return quizRepository.filterQuizTitle(title);
    }

    public String updateQuizById(Quiz body){
        quizRepository.updateQuizById(body.getDisable(), body.getId());

        return  "Atualizado com succeso!!!" ;
    }
}
