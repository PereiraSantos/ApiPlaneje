package com.api.planeje.revisionQuiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.api.planeje.revisionQuiz.entity.RevisionQuiz;
import com.api.planeje.revisionQuiz.dao.RevisionQuizRepository;

@Service
public class RevisionQuizService {

    @Autowired
    private RevisionQuizRepository revisionQuizRepository;

    public List<RevisionQuiz> GetRevisionQuiz() {
        return revisionQuizRepository.findAll();
    }

    public String saveRevisionQuiz(RevisionQuiz body) {
        RevisionQuiz revisionQuiz = new RevisionQuiz();
        revisionQuiz.setAnswer(body.getAnswer());
        revisionQuiz.setDateRevision(body.getDateRevision());
        revisionQuiz.setIdQuiz(body.getIdQuiz());
        revisionQuiz.setTopic(body.getTopic());
        revisionQuiz.setDescription(body.getDescription());


        revisionQuizRepository.save(revisionQuiz);
        return "Salvo com succeso!!!";
    }

    public RevisionQuiz getRevisivionQuizById(Integer id) {
        return revisionQuizRepository.getRevisionQuizById(id);
    }

    public List<RevisionQuiz> filterRevisionQuizTitle(String title) {
        return revisionQuizRepository.filterRevisionQuizTitle(title);
    }
}
