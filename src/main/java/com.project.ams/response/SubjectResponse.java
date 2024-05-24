package com.project.ams.response;

import java.util.List;

public class SubjectResponse {
    private List<String> subjectId;

    public List<String> getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(List<String> subjectId) {
        this.subjectId = subjectId;
    }

    public SubjectResponse(List<String> subjectId) {
        this.subjectId = subjectId;
    }
}
