package com.project.ams.controller;

import com.project.ams.request.LeaveRequest;
import com.project.ams.request.UpdateLeaveStatusRequest;
import com.project.ams.response.LeaveApproverResponse;
import com.project.ams.response.LeaveRequesterResponse;
import com.project.ams.response.LeaveResponse;
import com.project.ams.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    LeaveService leaveService;
    @PostMapping("/apply")
    public LeaveResponse leaveRequest(@RequestBody LeaveRequest leaveRequest) {

        return leaveService.createLeave(leaveRequest);

    }

    @GetMapping("/{leaveId}")
    public ResponseEntity<LeaveResponse> getLeaveById(@PathVariable String leaveId){
        LeaveResponse response = leaveService.getLeaveById(leaveId);
        if(response==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/approver")
    public LeaveApproverResponse getLeavesByApproverId(@RequestParam String approverId){
        return leaveService.getLeavesByApproverId(approverId);
    }

    @GetMapping("/requester")
    public LeaveRequesterResponse getLeavesByRequesterId(@RequestParam String requesterId){
        return leaveService.getLeavesByRequesterId(requesterId);
    }

    @PutMapping("/review")
    public LeaveResponse updateLeaveStatus(@RequestBody UpdateLeaveStatusRequest request){
        return leaveService.updateLeaveStatus(request);
    }

}
