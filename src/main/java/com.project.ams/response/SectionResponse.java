package com.project.ams.response;

import java.util.List;

public class SectionResponse {
    private List<String> sectionId;

    public List<String> getSectionId() {
        return sectionId;
    }

    public void setSectionId(List<String> sectionId) {
        this.sectionId = sectionId;
    }

    public SectionResponse(List<String> sectionId) {
        this.sectionId = sectionId;
    }
}
