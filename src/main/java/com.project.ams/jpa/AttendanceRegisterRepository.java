package com.project.ams.jpa;

import com.project.ams.entity.AttendanceRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRegisterRepository extends JpaRepository<AttendanceRegister, String> {

}
