package com.project.ams.controller;

import com.project.ams.entity.Student;
import com.project.ams.response.StudentResponse;
import com.project.ams.service.StudentService;
import com.project.ams.service.DataPopulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    DataPopulatorService dataPopulatorService;

    @GetMapping("/bySection")
    public List<Student> getStudentDetails(@RequestParam String sectionId) {
        return studentService.getStudents(sectionId);
    }

    @PostMapping("/populate")
    public ResponseEntity<String> populateDummyData() {
        dataPopulatorService.professorData();
        dataPopulatorService.sectionData();
        dataPopulatorService.subjectData();
        dataPopulatorService.studentData();
        return ResponseEntity.ok("OK");
    }
}