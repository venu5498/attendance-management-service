package com.project.ams.controller;


import com.project.ams.entity.Student;
import com.project.ams.request.ProfessorProfileRequest;
import com.project.ams.request.StudentProfileRequest;
import com.project.ams.response.ProfessorProfileResponse;
import com.project.ams.response.StudentProfileResponse;
import com.project.ams.service.ProfileService;
import com.project.ams.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("student", new Student());
        return "index";
    }

    @GetMapping("/student/{studentId}")
    public String getStudentProfile(@PathVariable String studentId, Model model){
        StudentProfileResponse studentProfileResponse = profileService.getStudentProfile(studentId);
        model.addAttribute("student", studentProfileResponse);
        return "studentDetails";
    }

    @PostMapping("/student")
    public String createStudentProfile(@ModelAttribute Student student,Model model){
        student = profileService.createStudent(student);
        model.addAttribute("message", "Student created with ID: " + student.getId());
        return "index";
    }

    @GetMapping("/professor/{professorId}")
    public ProfessorProfileResponse getProfessorProfile(@PathVariable String professorId){
        return profileService.getProfessorProfile(professorId);
    }

    @PostMapping("/professor")
    public ProfessorProfileResponse createProfessorProfile(@RequestBody ProfessorProfileRequest professorProfileRequest){
        return profileService.createProfessorProfile(professorProfileRequest);
    }


}
