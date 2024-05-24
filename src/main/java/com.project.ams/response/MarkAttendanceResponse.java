package com.project.ams.response;

public class MarkAttendanceResponse {

    private String statusCode;

    public String getStatusCode() {
        return statusCode;
    }

    public MarkAttendanceResponse(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
