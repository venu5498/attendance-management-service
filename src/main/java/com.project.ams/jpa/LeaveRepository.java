package com.project.ams.jpa;

import com.project.ams.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface LeaveRepository extends JpaRepository<Leave, String> {

    @Query("SELECT s FROM Leave s WHERE s.approverId = :approverId")
    List<Leave> findLeavesByApproverId(@Param("approverId") String approverId);


    @Query("SELECT s FROM Leave s WHERE s.requesterId = :requesterId")
    List<Leave> findLeavesByRequesterId(@Param("requesterId") String requesterId);

}
