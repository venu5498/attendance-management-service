package com.project.ams.jpa;

import com.project.ams.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section,String> {

    // Custom query method to fetch user by email
    @Query("SELECT s FROM Section s WHERE s.professorId = :professorId")
    List<Section> findSectionsByProfessorId(@Param("professorId") String professorId);

}
