package com.project.ams.request;

import com.project.ams.enums.AttendanceStatus;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Map;

@ToString
public class MarkAttendanceRequest {
    private LocalDate dateOfAttendance;
    private String sectionId;
    private String subjectId;

    private Map<String, AttendanceStatus> attendanceStatusMap;

    private String professorId;

    public Map<String, AttendanceStatus> getAttendanceStatusMap() {
        return attendanceStatusMap;
    }

    public void setAttendanceStatusMap(Map<String, AttendanceStatus> attendanceStatusMap) {
        this.attendanceStatusMap = attendanceStatusMap;
    }

    public LocalDate getDateOfAttendance() {
        return dateOfAttendance;
    }

    public void setDateOfAttendance(LocalDate dateOfAttendance) {
        this.dateOfAttendance = dateOfAttendance;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }


}
