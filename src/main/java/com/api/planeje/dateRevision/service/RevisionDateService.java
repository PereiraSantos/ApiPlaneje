package com.api.planeje.dateRevision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.planeje.ResponseDto;
import com.api.planeje.dateRevision.dao.RevisionDateRepository;
import com.api.planeje.dateRevision.entity.RevisionDate;

@Service
public class RevisionDateService {

    @Autowired
    private RevisionDateRepository dateRevisionRepository;

    public List<RevisionDate> GetDateRevision() {
        return dateRevisionRepository.findAll();
    }

    public ResponseEntity<ResponseDto> saveDateRevision(RevisionDate body) {
        RevisionDate revision = new RevisionDate();

        if (body.getId() != null) {
            revision.setId(body.getId());
        } else {
            Integer id = dateRevisionRepository.lastId();
            id = id == null ? 1 : id + 1;

            revision.setId(id);
            revision.setDisable(0);
        }

        revision.setDateRevision(body.getDateRevision());
        revision.setIdRevision(body.getIdRevision());

        revision = dateRevisionRepository.save(revision);

        return ResponseEntity.ok().body(new ResponseDto(revision.getId(),
                body.getId() != null ? "Atualizado com succeso!!!" : "Salvo com succeso!!!"));
    }

    public RevisionDate getDateRevisivioById(Integer id) {
        return dateRevisionRepository.getDateRevisionById(id);
    }

    public List<RevisionDate> filterDateRevisionTitle(String title) {
        return dateRevisionRepository.filterDateRevisionTitle(title);
    }

    public String updateDateRevisionById(RevisionDate body) {
        dateRevisionRepository.updateDateRevisionById(body.getDisable(), body.getId());

        return "Atualizado com succeso!!!";
    }
}
