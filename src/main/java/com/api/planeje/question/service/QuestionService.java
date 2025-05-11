package com.api.planeje.question.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.planeje.question.dao.QuestionRepository;
import com.api.planeje.question.entity.Question;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> GetQuestion() {
        return questionRepository.findAll();
    }

    public String saveQuestion(Question body) {
        Question question = new Question();

        if (body.getId() != null) question.setId(body.getId());

        question.setIdQuiz(body.getIdQuiz());
        question.setDescription(body.getDescription());
        question.setAnswer(body.getAnswer());

        questionRepository.save(question);

        return body.getId() != null ? "Atualizado com succeso!!!" : "Salvo com succeso!!!";
    }

    public Question getQuestionById(Integer id) {
        return questionRepository.getQuestionById(id);
    }

    public List<Question> filterQuestionTitle(String title) {
        return questionRepository.filterQuestionTitle(title);
    }
}
