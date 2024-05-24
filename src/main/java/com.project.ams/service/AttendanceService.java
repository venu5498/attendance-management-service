package com.project.ams.service;

import com.project.ams.entity.Attendance;
import com.project.ams.entity.AttendanceRegister;
import com.project.ams.enums.AttendanceStatus;
import com.project.ams.jpa.AttendanceRegisterRepository;
import com.project.ams.jpa.AttendanceRepository;
import com.project.ams.request.MarkAttendanceRequest;
import com.project.ams.response.AttendanceResponse;
import com.project.ams.response.MarkAttendanceResponse;
import com.project.ams.response.StudentAttendanceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    AttendanceRegisterRepository attendanceRegisterRepository;
    @Autowired
    AttendanceRepository attendanceRepository;

    public AttendanceResponse getAttendanceBySubject(String subjectId) {
        List<Attendance> attendanceList = attendanceRepository.getAttendanceBySubject(subjectId);
        Map<String, Double> studentAttendanceMap = new HashMap<>();
        for (Attendance attendance : attendanceList) {
            studentAttendanceMap.put(attendance.getStudentId(), attendance.getPercentage());
        }
        return new AttendanceResponse(studentAttendanceMap);
    }

    public MarkAttendanceResponse markAttendance(MarkAttendanceRequest markAttendanceRequest) {

        Map<String, AttendanceStatus> studentsAttendance = markAttendanceRequest.getAttendanceStatusMap();

        for (Map.Entry<String, AttendanceStatus> studentAttendance : studentsAttendance.entrySet()) {
            String studentId = studentAttendance.getKey();
            String attendanceStatus = studentAttendance.getValue().toString();

            // update in register 
            updateInRegister(markAttendanceRequest, studentId, attendanceStatus);

            // update in user
            updateInUser(markAttendanceRequest, studentId, attendanceStatus);
        }

        return new MarkAttendanceResponse(" 200 ");
    }

    private void updateInUser(MarkAttendanceRequest markAttendanceRequest, String studentId, String attendanceStatus) {
        Optional<Attendance> attendance = attendanceRepository.getAttendanceByStudentId(studentId);
        if (attendance.isPresent()) {
            Attendance oldAttendance = attendance.get();
            int attendedClasses = "PRESENT".equalsIgnoreCase(attendanceStatus) ? oldAttendance.getAttendedClasses() + 1 : oldAttendance.getAttendedClasses();
            int totalClasses = oldAttendance.getTotalClasses() + 1;
            oldAttendance.setTotalClasses(totalClasses);
            oldAttendance.setAttendedClasses(attendedClasses);
            oldAttendance.setPercentage(((double) attendedClasses / totalClasses) * 100);
            oldAttendance.setSubjectId(markAttendanceRequest.getSubjectId());
            attendanceRepository.save(oldAttendance);
        } else {
            int totalClasses = 1;
            int attendedClasses = "PRESENT".equalsIgnoreCase(attendanceStatus) ? 1 : 0;
            double percentage = ((double) attendedClasses / totalClasses) * 100;
            Attendance newAttendance = new Attendance(percentage, totalClasses, attendedClasses, studentId, markAttendanceRequest.getSubjectId());
            attendanceRepository.save(newAttendance);
        }
    }

    private void updateInRegister(MarkAttendanceRequest markAttendanceRequest, String studentId, String attendanceStatus) {
        AttendanceRegister register = new AttendanceRegister();
        register.setStudentId(studentId);
        register.setSectionId(markAttendanceRequest.getSectionId());
        register.setProfessorId(markAttendanceRequest.getProfessorId());
        register.setDateOfAttendance(markAttendanceRequest.getDateOfAttendance());
        register.setAttendanceStatus(attendanceStatus);
        attendanceRegisterRepository.save(register);

    }

    public StudentAttendanceResponse getStudentAttendance(String studentId) {
        StudentAttendanceResponse studentAttendanceResponse = new StudentAttendanceResponse();
        Optional<Attendance> attendance = attendanceRepository.getAttendanceByStudentId(studentId);
        if (attendance.isEmpty()) {
            return studentAttendanceResponse;
        } else {
            Attendance studentAttendance = attendance.get();
            studentAttendanceResponse.setStudentId(studentId);
            studentAttendanceResponse.setPercentage(studentAttendance.getPercentage());
            studentAttendanceResponse.setAttendedClasses(studentAttendance.getAttendedClasses());
            studentAttendanceResponse.setTotalClasses(studentAttendance.getTotalClasses());
            studentAttendance.setSubjectId(studentAttendance.getSubjectId());
            return studentAttendanceResponse;
        }
    }


}

