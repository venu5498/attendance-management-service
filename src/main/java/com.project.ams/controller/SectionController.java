package com.project.ams.controller;

import com.project.ams.entity.Section;
import com.project.ams.response.SectionResponse;
import com.project.ams.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sections")
public class SectionController {

    @Autowired
    SectionService sectionService;

    @GetMapping("/active")
    public List<Section> getSection(@RequestParam String professorId) {
        return sectionService.getSections(professorId);
    }

}







