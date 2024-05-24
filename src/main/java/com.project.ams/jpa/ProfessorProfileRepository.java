package com.project.ams.jpa;

import com.project.ams.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface ProfessorProfileRepository extends JpaRepository<Professor, String> {
    @Query("SELECT p FROM Professor p WHERE p.id = :professorId")
    Professor findProfessorProfileByProfessorId(@Param("professorId") String professorId);
}
