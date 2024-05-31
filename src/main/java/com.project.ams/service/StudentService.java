package com.project.ams.service;

import com.project.ams.entity.Student;
import com.project.ams.jpa.StudentProfileRepository;
import com.project.ams.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Autowired
    StudentProfileRepository studentProfileRepository;

    public List<Student>  getStudents(String sectionId) {
        List<Student> studentList = studentProfileRepository.getStudentsBySectionId(sectionId);
        Map<String, String> studentMap = new HashMap<>();
        System.out.println("Student List: "+studentList);
        for (Student student : studentList) {
            studentMap.put(student.getId(), student.getName());
        }
        return studentList;
    }

}
