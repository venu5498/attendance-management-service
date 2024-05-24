package com.project.ams.jpa;

import com.project.ams.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentProfileRepository extends JpaRepository<Student, String> {
    @Query("SELECT s FROM Student s WHERE s.id = :studentId")
    Student findStudentProfileByStudentId(@Param("studentId") String studentId);
    @Query("SELECT a from Student a where a.sectionId = :sectionId")
    List<Student> getStudentsBySectionId(@Param("sectionId") String sectionId);
}
