package com.project.ams.request;

import java.time.LocalDate;

public class StudentProfileRequest {
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

    public StudentProfileRequest() {
    }

    public StudentProfileRequest(String name, String email, int current_year, String mobileNumber, LocalDate dob, String father_name, String mother_name, String address, String dept, String sectionId) {
        this.name = name;
        this.email = email;
        this.current_year = current_year;
        this.mobileNumber = mobileNumber;
        this.dob = dob;
        this.father_name = father_name;
        this.mother_name = mother_name;
        this.address = address;
        this.dept = dept;
        this.sectionId = sectionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCurrent_year() {
        return current_year;
    }

    public void setCurrent_year(int current_year) {
        this.current_year = current_year;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }
}
