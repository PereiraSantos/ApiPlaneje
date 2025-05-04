package com.api.planeje.dateRevision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.planeje.dateRevision.dao.RevisionDateRepository;
import com.api.planeje.dateRevision.entity.RevisionDate;

@Service
public class RevisionDateService {

    @Autowired
    private RevisionDateRepository dateRevisionRepository;

    public List<RevisionDate> GetDateRevision() {
        return dateRevisionRepository.findAll();
    }

    public String saveDateRevision(RevisionDate body) {
        RevisionDate revision = new RevisionDate();
        revision.setDateRevision(body.getDateRevision());
        revision.setIdRevision(body.getIdRevision());

        dateRevisionRepository.save(revision);
        return "Salvo com succeso!!!";
    }

    public RevisionDate getDateRevisivioById(Integer id) {
        return dateRevisionRepository.getDateRevisionById(id);
    }

    public List<RevisionDate> filterDateRevisionTitle(String title) {
        return dateRevisionRepository.filterDateRevisionTitle(title);
    }
}
