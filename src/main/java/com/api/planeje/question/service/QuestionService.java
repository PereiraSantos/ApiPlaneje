package com.api.planeje.question.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.planeje.ResponseDto;
import com.api.planeje.question.dao.QuestionRepository;
import com.api.planeje.question.entity.Question;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> GetQuestion() {
        return questionRepository.findAll();
    }

    public ResponseEntity<ResponseDto> saveQuestion(Question body) {
        Question question = new Question();

        if (body.getId() != null) {
            question.setId(body.getId());
        } else {
            Integer id = questionRepository.lastId();
            id = id == null ? 1 : id + 1;

            question.setId(id);
            question.setDisable(0);
        }

        question.setIdQuiz(body.getIdQuiz());
        question.setDescription(body.getDescription());
        question.setAnswer(body.getAnswer());

        question = questionRepository.save(question);

        return ResponseEntity.ok().body(new ResponseDto(question.getId(),
                body.getId() != null ? "Atualizado com succeso!!!" : "Salvo com succeso!!!"));
    }

    public Question getQuestionById(Integer id) {
        return questionRepository.getQuestionById(id);
    }

    public List<Question> filterQuestionTitle(String title) {
        return questionRepository.filterQuestionTitle(title);
    }

    public String updateQuestionById(Question body) {
        questionRepository.updateQuestionById(body.getDisable(), body.getId());

        return "Atualizado com succeso!!!";
    }
}
