package com.project.ams.service;

import com.project.ams.entity.Leave;
import com.project.ams.jpa.LeaveRepository;
import com.project.ams.enums.LeaveStatus;
import com.project.ams.request.LeaveRequest;
import com.project.ams.request.UpdateLeaveStatusRequest;
import com.project.ams.response.LeaveApproverResponse;
import com.project.ams.response.LeaveRequesterResponse;
import com.project.ams.response.LeaveResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LeaveService {

    @Autowired
    LeaveRepository leaveRepository;

    public LeaveApproverResponse getLeavesByApproverId(String approverId) {
        List<Leave> leaves = leaveRepository.findLeavesByApproverId(String.valueOf(approverId));
        List<String> leaveIds = new ArrayList<>();
        leaves.forEach(leave -> leaveIds.add(leave.getId()));
        return new LeaveApproverResponse(leaveIds);
    }

    public LeaveRequesterResponse getLeavesByRequesterId(String requesterId) {
        List<Leave> leaves = leaveRepository.findLeavesByRequesterId(String.valueOf(requesterId));
        List<String> leaveIds = new ArrayList<>();
        leaves.forEach(leave -> leaveIds.add(leave.getId()));
        return new LeaveRequesterResponse(leaveIds);
    }


    public LeaveResponse createLeave(LeaveRequest leaveRequest) {
        Leave leave = new Leave();
        leave.setRequesterId(leaveRequest.getRequesterId());
        leave.setType(leaveRequest.getType());
        leave.setApproverId(leaveRequest.getApproverId());
        leave.setBody(leaveRequest.getBody());
        leave.setLeave_status(LeaveStatus.APPLIED.toString());
        leave = leaveRepository.save(leave);
        return new LeaveResponse(leave.getId(), leave.getRequesterId(), leave.getApproverId(), leave.getBody(), leave.getType(), leave.getLeave_status());
    }

    public LeaveResponse getLeaveById(String leaveId) {
        LeaveResponse leaveResponse = new LeaveResponse();
        Optional<Leave> leave = leaveRepository.findById(leaveId);
        if (leave.isEmpty()) {
            return null;
        } else {
            Leave currentLeave = leave.get();
            leaveResponse.setLeaveId(leaveId);
            leaveResponse.setType(currentLeave.getType());
            leaveResponse.setApproverId(currentLeave.getApproverId());
            leaveResponse.setRequesterId(currentLeave.getRequesterId());
            leaveResponse.setBody(currentLeave.getBody());
            leaveResponse.setStatus(currentLeave.getLeave_status());
            return leaveResponse;
        }
    }

    public LeaveResponse updateLeaveStatus(UpdateLeaveStatusRequest request) {
        LeaveResponse leaveResponse = new LeaveResponse();
        Optional<Leave> leave = leaveRepository.findById(request.getLeaveId());
        if (leave.isEmpty()) {
            return leaveResponse;
        } else {
            Leave currLeave = leave.get();
            currLeave.setLeave_status(request.getLeaveStatus());
            currLeave.setComments(request.getComment());
            currLeave = leaveRepository.save(currLeave);
            leaveResponse.setLeaveId(currLeave.getId());
            leaveResponse.setStatus(currLeave.getLeave_status());
            leaveResponse.setBody(currLeave.getBody());
            leaveResponse.setType(currLeave.getType());
            leaveResponse.setApproverId(currLeave.getApproverId());
            leaveResponse.setRequesterId(currLeave.getRequesterId());
            leaveResponse.setLeaveId(leaveResponse.getLeaveId());
            return leaveResponse;
        }
    }
}
