package com.project.ams.request;

public class UpdateLeaveStatusRequest {
    private String leaveId;
    private String leaveStatus;
    private String comment;

    public String getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(String leaveId) {
        this.leaveId = leaveId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        comment = comment;
    }

    public String getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(String leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    public UpdateLeaveStatusRequest(String leaveId, String leaveStatus, String comment) {
        this.leaveId = leaveId;
        this.leaveStatus = leaveStatus;
        this.comment = comment;
    }

    public UpdateLeaveStatusRequest() {
    }
}
