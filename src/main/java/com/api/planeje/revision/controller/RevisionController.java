package com.api.planeje.revision.controller;

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

import com.api.planeje.revision.entity.Revision;
import com.api.planeje.revision.service.RevisionService;

@RestController
@RequestMapping("/revision")
public class RevisionController {
    
    @Autowired
    private RevisionService revisionService;

    @GetMapping()
    public @ResponseBody List<Revision> GetRevision() {
        return revisionService.GetRevision();
    }

    @PostMapping()
    public @ResponseBody String saveRevision(@RequestBody Revision body) {
        return revisionService.saveRevision(body);
    }

    @PostMapping("/update")
    public @ResponseBody String updateRevisionById(@RequestBody Revision body) {
        return revisionService.updateRevisionById(body);
    }

    @GetMapping("/{id}")
    public @ResponseBody Revision getRevisivioById(@PathVariable String id) {
        return revisionService.getRevisivioById(Integer.valueOf(id));
    }

    @GetMapping("/search")
    public @ResponseBody Iterable<Revision> filterRevisionTitle(@RequestParam(value = "title") String title) {
        return revisionService.filterRevisionTitle(title);
    }

}
