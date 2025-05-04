package com.api.planeje.dateRevision.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.planeje.dateRevision.entity.RevisionDate;
import com.api.planeje.dateRevision.service.RevisionDateService;


@RestController
@RequestMapping("/revision/date")
public class RevisionDateController {
    
    @Autowired
    private RevisionDateService dateRevisionService;

    @GetMapping()
    public @ResponseBody List<RevisionDate> GetDateRevision() {
        return dateRevisionService.GetDateRevision();
    }

    @PostMapping()
    public @ResponseBody String saveDateRevision(@RequestBody RevisionDate body) {
        return dateRevisionService.saveDateRevision(body);
    }

    @GetMapping("/{id}")
    public @ResponseBody RevisionDate getDateRevisivioById(@PathVariable String id) {
        return dateRevisionService.getDateRevisivioById(Integer.valueOf(id));
    }

    @GetMapping("/search")
    public @ResponseBody Iterable<RevisionDate> filterDateRevisionTitle(@RequestParam(value = "title") String title) {
        return dateRevisionService.filterDateRevisionTitle(title);
    }

}
