package com.project.ams.controller;


import com.project.ams.request.ProfessorProfileRequest;
import com.project.ams.request.StudentProfileRequest;
import com.project.ams.response.ProfessorProfileResponse;
import com.project.ams.response.StudentProfileResponse;
import com.project.ams.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping("/student/{studentId}")
    public StudentProfileResponse getStudentProfile(@PathVariable String studentId){
        return profileService.getStudentProfile(studentId);
    }

    @PostMapping("/student")
    public StudentProfileResponse createStudentProfile(@RequestBody StudentProfileRequest studentProfileRequest){
        return profileService.createStudentProfile(studentProfileRequest);
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
