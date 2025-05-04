package com.api.planeje.revision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.api.planeje.revision.dao.RevisionRepository;
import com.api.planeje.revision.entity.Revision;

@Service
public class RevisionService {

    @Autowired
    private RevisionRepository revisionRepository;

    public List<Revision> GetRevision() {
        return revisionRepository.findAll();
    }

    public String saveRevision(Revision body) {
        Revision revision = new Revision();
        revision.setTitle(body.getTitle());
        revision.setDescription(body.getDescription());
        revision.setDateCreational(body.getDateCreational());
        revision.setIdRevisionTheme(body.getIdRevisionTheme());

        revisionRepository.save(revision);
        return "Salvo com succeso!!!";
    }

    public Revision getRevisivioById(Integer id) {
        return revisionRepository.getRevisionById(id);
    }

    public List<Revision> filterRevisionTitle(String title) {
        return revisionRepository.filterRevisionTitle(title);
    }
}
