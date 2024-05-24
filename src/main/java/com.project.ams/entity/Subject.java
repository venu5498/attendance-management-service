package com.project.ams.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import java.util.UUID;

@Entity
public class Subject {
    @Id
    private String id;

    @PrePersist
    public void ensureId() {
        if (this.id == null || this.id.isEmpty()) {
            this.id = UUID.randomUUID().toString();
        }
    }
    private String name ;
    private String sectionId;

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

    public String getSection_id() {
        return sectionId;
    }

    public void setSection_id(String section_id) {
        this.sectionId = section_id;
    }

    public Subject() {
    }

    public Subject(String name, String section_id) {

        this.name = name;
        this.sectionId = section_id;
    }
}
