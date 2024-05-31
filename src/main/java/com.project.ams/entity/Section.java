package com.project.ams.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Section {
    @Id
    private String id;
    private String name;
    private String professorId;

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


