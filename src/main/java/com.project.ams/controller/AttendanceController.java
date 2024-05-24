package com.project.ams.controller;


import com.project.ams.request.MarkAttendanceRequest;
import com.project.ams.response.AttendanceResponse;
import com.project.ams.response.MarkAttendanceResponse;
import com.project.ams.response.StudentAttendanceResponse;
import com.project.ams.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;


    @PostMapping("/mark")
    public MarkAttendanceResponse markAttendance(@RequestBody MarkAttendanceRequest markAttendanceRequest) {
        return attendanceService.markAttendance(markAttendanceRequest);
    }

    @GetMapping("/Students")
    public AttendanceResponse getAttendanceReport(
            @RequestParam("subjectID") String subjectId,
            @RequestParam("minimumPercentage") double minimumPercentage) {

        return attendanceService.getAttendanceBySubject(subjectId);
    }

    @GetMapping("/{studentId}")
    public StudentAttendanceResponse getStudentAttendance(@PathVariable String studentId){
        return attendanceService.getStudentAttendance(studentId);
    }



}

