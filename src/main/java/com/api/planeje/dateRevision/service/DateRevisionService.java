package com.api.planeje.dateRevision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.planeje.dateRevision.dao.DateRevisionRepository;
import com.api.planeje.dateRevision.entity.DateRevision;

@Service
public class DateRevisionService {

    @Autowired
    private DateRevisionRepository dateRevisionRepository;

    public List<DateRevision> GetDateRevision() {
        return dateRevisionRepository.findAll();
    }

    public String saveDateRevision(DateRevision body) {
        DateRevision revision = new DateRevision();
        revision.setDate(body.getDate());
        revision.setIdRevision(body.getIdRevision());

        dateRevisionRepository.save(revision);
        return "Salvo com succeso!!!";
    }

    public DateRevision getDateRevisivioById(Integer id) {
        return dateRevisionRepository.getDateRevisionById(id);
    }

    public List<DateRevision> filterDateRevisionTitle(String title) {
        return dateRevisionRepository.filterDateRevisionTitle(title);
    }
}
