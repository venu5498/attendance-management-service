package com.project.ams.response;

import java.util.Map;

public class StudentResponse {
    private Map<String,String> studentMap;

    public Map<String, String> getSectionId() {
        return studentMap;
    }

    public StudentResponse(Map<String, String> sectionId) {
        this.studentMap = sectionId;
    }

    public void setSectionId(Map<String, String> sectionId) {
        this.studentMap = sectionId;
    }
}
