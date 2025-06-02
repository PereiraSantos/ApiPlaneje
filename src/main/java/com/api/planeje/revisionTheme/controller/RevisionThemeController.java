package com.api.planeje.revisionTheme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.planeje.ResponseDto;
import com.api.planeje.revisionTheme.entity.RevisionTheme;
import com.api.planeje.revisionTheme.service.RevisionThemeService;

@RestController
@RequestMapping("/revision/theme")
public class RevisionThemeController {

    @Autowired
    private RevisionThemeService revisionThemeService;

    @GetMapping()
    public @ResponseBody List<RevisionTheme> GetRevisionTheme() {
        return revisionThemeService.GetRevisionTheme();
    }

    @PostMapping()
    public @ResponseBody ResponseEntity<ResponseDto> saveRevisionTheme(@RequestBody RevisionTheme body) {
        return revisionThemeService.saveRevisionTheme(body);
    }

    @PostMapping("/update")
    public @ResponseBody String updateRevisionThemeById(@RequestBody RevisionTheme body) {
        return revisionThemeService.updateRevisionThemeById(body);
    }

    @GetMapping("/{id}")
    public @ResponseBody RevisionTheme getRevisivioById(@PathVariable String id) {
        return revisionThemeService.getRevisivionThemeById(Integer.valueOf(id));
    }

    @GetMapping("/search")
    public @ResponseBody Iterable<RevisionTheme> filterRevisionTitle(@RequestParam(value = "title") String title) {
        return revisionThemeService.filterRevisionThemeTitle(title);
    }
}
