package com.project.ams.jpa;

import com.project.ams.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, String> {

    @Query("SELECT s FROM Subject s WHERE s.sectionId = :sectionId")
    List<Subject> findSubjectsBySectionId(@Param("sectionId") String sectionId);
}
