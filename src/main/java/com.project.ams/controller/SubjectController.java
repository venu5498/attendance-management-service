package com.project.ams.controller;

import com.project.ams.entity.Subject;
import com.project.ams.response.SubjectResponse;
import com.project.ams.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
        @Autowired
        SubjectService subjectService;

        @GetMapping("/active")
        public List<Subject> getSubject(@RequestParam String sectionId) {
                return subjectService.getSubject(sectionId);
        }
}
