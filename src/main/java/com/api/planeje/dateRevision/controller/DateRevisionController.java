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

import com.api.planeje.dateRevision.entity.DateRevision;
import com.api.planeje.dateRevision.service.DateRevisionService;


@RestController
@RequestMapping("/date-revision")
public class DateRevisionController {
    
    @Autowired
    private DateRevisionService dateRevisionService;

    @GetMapping()
    public @ResponseBody List<DateRevision> GetDateRevision() {
        return dateRevisionService.GetDateRevision();
    }

    @PostMapping()
    public @ResponseBody String saveDateRevision(@RequestBody DateRevision body) {
        return dateRevisionService.saveDateRevision(body);
    }

    @GetMapping("/{id}")
    public @ResponseBody DateRevision getDateRevisivioById(@PathVariable String id) {
        return dateRevisionService.getDateRevisivioById(Integer.valueOf(id));
    }

    @GetMapping("/search")
    public @ResponseBody Iterable<DateRevision> filterDateRevisionTitle(@RequestParam(value = "title") String title) {
        return dateRevisionService.filterDateRevisionTitle(title);
    }

}
