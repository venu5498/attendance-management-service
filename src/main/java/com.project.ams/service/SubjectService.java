package com.project.ams.service;

import com.project.ams.entity.Subject;
import com.project.ams.jpa.SubjectRepository;
import com.project.ams.response.SubjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    public List<Subject> getSubject(String sectionId) {
        List<Subject> subjects = subjectRepository.findSubjectsBySectionId(String.valueOf(sectionId));
        System.out.println("For sectionId: " + sectionId + " subjects are: " + subjects.toString());

        return subjects;

    }
}


