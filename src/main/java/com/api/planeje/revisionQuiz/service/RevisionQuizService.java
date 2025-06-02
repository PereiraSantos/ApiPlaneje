package com.api.planeje.revisionQuiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.planeje.revisionQuiz.entity.RevisionQuiz;
import com.api.planeje.ResponseDto;
import com.api.planeje.revisionQuiz.dao.RevisionQuizRepository;

@Service
public class RevisionQuizService {

    @Autowired
    private RevisionQuizRepository revisionQuizRepository;

    public List<RevisionQuiz> GetRevisionQuiz() {
        return revisionQuizRepository.findAll();
    }

    public ResponseEntity<ResponseDto> saveRevisionQuiz(RevisionQuiz body) {
        RevisionQuiz revisionQuiz = new RevisionQuiz();

        if (body.getId() != null) {
            revisionQuiz.setId(body.getId());
        } else {
            Integer id = revisionQuizRepository.lastId();
            id = id == null ? 1 : id + 1;

            revisionQuiz.setId(id);
            revisionQuiz.setDisable(0);
        }

        revisionQuiz.setAnswer(body.getAnswer());
        revisionQuiz.setDateRevision(body.getDateRevision());
        revisionQuiz.setIdQuiz(body.getIdQuiz());

        revisionQuiz = revisionQuizRepository.save(revisionQuiz);

        return ResponseEntity.ok().body(new ResponseDto(revisionQuiz.getId(),
                body.getId() != null ? "Atualizado com succeso!!!" : "Salvo com succeso!!!"));

    }

    public RevisionQuiz getRevisivionQuizById(Integer id) {
        return revisionQuizRepository.getRevisionQuizById(id);
    }

    public List<RevisionQuiz> filterRevisionQuizTitle(String title) {
        return revisionQuizRepository.filterRevisionQuizTitle(title);
    }

    public String updateRevisionQuizById(RevisionQuiz body) {
        revisionQuizRepository.updateRevisionQuizById(body.getDisable(), body.getId());

        return "Atualizado com succeso!!!";
    }

}
