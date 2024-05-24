package com.project.ams.jpa;

import com.project.ams.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, String> {

    @Query("SELECT a from Attendance a where a.studentId = :studentId")
    Optional<Attendance> getAttendanceByStudentId(@Param("studentId") String studentId);

    @Query("SELECT a from Attendance a where a.subjectId = :subjectId")
    List<Attendance> getAttendanceBySubject(@Param("subjectId") String subjectId);

}
