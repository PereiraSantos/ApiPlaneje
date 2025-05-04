package com.api.planeje.revisionTheme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.planeje.revisionTheme.dao.RevisionThemeRepository;
import com.api.planeje.revisionTheme.entity.RevisionTheme;

@Service
public class RevisionThemeService {

    @Autowired
    RevisionThemeRepository revisionThemeRepository;

       public List<RevisionTheme> GetRevisionTheme() {
        return revisionThemeRepository.findAll();
    }

    public String saveRevisionTheme(RevisionTheme body) {
        RevisionTheme revisionTheme = new RevisionTheme();
 
        revisionTheme.setDescription(body.getDescription());
  

        revisionThemeRepository.save(revisionTheme);
        return "Salvo com succeso!!!";
    }

    public RevisionTheme getRevisivionThemeById(Integer id) {
        return revisionThemeRepository.getRevisionThemeById(id);
    }

    public List<RevisionTheme> filterRevisionThemeTitle(String title) {
        return revisionThemeRepository.filterRevisionThemeTitle(title);
    }
}
