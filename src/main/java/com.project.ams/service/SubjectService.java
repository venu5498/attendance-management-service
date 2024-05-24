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

    public SubjectResponse getSubject(String sectionId) {
        List<Subject> subjects = subjectRepository.findSubjectsBySectionId(String.valueOf(sectionId));
        List<String> subjectIds = new ArrayList<>();
        subjects.forEach(subject -> subjectIds.add(subject.getId()));
        return new SubjectResponse(subjectIds);
    }
}


