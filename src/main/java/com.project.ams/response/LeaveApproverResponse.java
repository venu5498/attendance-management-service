package com.project.ams.response;

import java.util.List;

public class LeaveApproverResponse {
    private List<String> leave;

    public List<String> getLeave() {
        return leave;
    }

    public void setLeave(List<String> leave) {
        this.leave = leave;
    }

    public LeaveApproverResponse(List<String> leave) {
        this.leave = leave;
    }
}
