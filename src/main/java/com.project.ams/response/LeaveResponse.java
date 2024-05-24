package com.project.ams.response;

public class LeaveResponse {
    private String leaveId;
    private String requesterId;
    private String approverId;
    private String body;
    private String type;

    private String status;

    public String getBody() {
        return body;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(String leaveId) {
        this.leaveId = leaveId;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public String getApproverId() {
        return approverId;
    }

    public void setApproverId(String approverId) {
        this.approverId = approverId;
    }

    public LeaveResponse() {
    }

    public LeaveResponse(String leaveId, String requesterId, String approverId, String body, String type, String status) {
        this.leaveId = leaveId;
        this.requesterId = requesterId;
        this.approverId = approverId;
        this.body = body;
        this.type = type;
        this.status = status;
    }
}
