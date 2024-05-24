package com.project.ams.response;

import java.util.Map;


public class AttendanceResponse {
    private Map<String, Double> attendanceMap;

    public AttendanceResponse(Map<String, Double> attendanceMap) {
        this.attendanceMap = attendanceMap;
    }

    public Map<String, Double> getAttendanceMap() {
        return attendanceMap;
    }

    public void setAttendanceMap(Map<String, Double> attendanceMap) {
        this.attendanceMap = attendanceMap;
    }
}
