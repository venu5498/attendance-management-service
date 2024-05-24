package com.project.ams.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import java.util.UUID;

@Entity
public class Section {
    @Id
    private String id;
    private String name;
    private String professorId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessor_id() {
        return professorId;
    }

    public void setProfessor_id(String professor_id) {
        this.professorId = professor_id;
    }

    public Section() {
    }

    @PrePersist
    public void ensureId() {
        if (this.id == null || this.id.isEmpty()) {
            this.id = UUID.randomUUID().toString();
        }
    }

    public Section(String name, String professor_id) {
        this.name = name;
        this.professorId = professor_id;
    }
}


