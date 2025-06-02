package com.api.planeje.revisionTheme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.planeje.ResponseDto;
import com.api.planeje.revisionTheme.dao.RevisionThemeRepository;
import com.api.planeje.revisionTheme.entity.RevisionTheme;

@Service
public class RevisionThemeService {

    @Autowired
    RevisionThemeRepository revisionThemeRepository;

    public List<RevisionTheme> GetRevisionTheme() {
        return revisionThemeRepository.findAll();
    }

    public ResponseEntity<ResponseDto> saveRevisionTheme(RevisionTheme body) {
        RevisionTheme revisionTheme = new RevisionTheme();

        if (body.getId() != null) {
            revisionTheme.setId(body.getId());
        } else {
            Integer id = revisionThemeRepository.lastId();
            id = id == null ? 1 : id + 1;

            revisionTheme.setId(id);
            revisionTheme.setDisable(0);
        }

        revisionTheme.setDescription(body.getDescription());

        revisionTheme = revisionThemeRepository.save(revisionTheme);

        return ResponseEntity.ok().body(new ResponseDto(revisionTheme.getId(),
                body.getId() != null ? "Atualizado com succeso!!!" : "Salvo com succeso!!!"));

    }

    public RevisionTheme getRevisivionThemeById(Integer id) {
        return revisionThemeRepository.getRevisionThemeById(id);
    }

    public List<RevisionTheme> filterRevisionThemeTitle(String title) {
        return revisionThemeRepository.filterRevisionThemeTitle(title);
    }

    public String updateRevisionThemeById(RevisionTheme body) {
        revisionThemeRepository.updateRevisionThemeById(body.getDisable(), body.getId());

        return "Atualizado com succeso!!!";
    }
}
