package com.project.ams.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Student {
    @Id
    private String id;
    private String name ;
    private String email;
    private int current_year ;
    private String mobileNumber;
    private LocalDate dob;
    private String father_name;
    private String mother_name;
    private String address;
    private String dept;
    private String sectionId;

    @PrePersist
    public void ensureId() {
        if (this.id == null || this.id.isEmpty()) {
            this.id = UUID.randomUUID().toString();
        }
    }
}
