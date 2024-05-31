package com.project.ams.service;

import com.project.ams.entity.Section;
import com.project.ams.jpa.SectionRepository;
import com.project.ams.response.SectionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionService {

    @Autowired
    SectionRepository sectionRepository;

    public List<Section> getSections(String professorId) {
        List<Section> sections = sectionRepository.findSectionsByProfessorId(professorId);
        List<String> sectionIds = new ArrayList<>();
        sections.forEach(section -> sectionIds.add(section.getId()));
        System.out.println("For professorId: " + professorId + " sections are: " + sections.toString());
        return sections;
    }
}
