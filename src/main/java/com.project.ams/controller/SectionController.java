package com.project.ams.controller;

import com.project.ams.response.SectionResponse;
import com.project.ams.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sections")
public class SectionController {

    @Autowired
    SectionService sectionService;

    @GetMapping("/active")
    public SectionResponse getSection(@RequestParam String professorId) {
        return sectionService.getSections(professorId);
    }

}







