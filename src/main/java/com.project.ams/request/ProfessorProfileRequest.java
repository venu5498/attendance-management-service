package com.project.ams.request;

import java.time.LocalDate;

public class ProfessorProfileRequest {

        private String name;
        private String dept;
        private String email ;
        private LocalDate date_of_joining;
        private String mobileNumber;
        private LocalDate dob;
        private String father_name;
        private String mother_name;
        private String address ;
        private String did;

    public ProfessorProfileRequest() {
    }

    public ProfessorProfileRequest(String name,String dept, String email, LocalDate date_of_joining, String mobileNumber, LocalDate dob, String father_name, String mother_name, String address, String did) {

            this.name = name;
            this.dept=dept;
            this.email = email;
            this.date_of_joining = date_of_joining;
            this.mobileNumber = mobileNumber;
            this.dob = dob;
            this.father_name = father_name;
            this.mother_name = mother_name;
            this.address = address;
            this.did = did;
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

        public LocalDate getDate_of_joining() {
            return date_of_joining;
        }

        public void setDate_of_joining(LocalDate date_of_joining) {
            this.date_of_joining = date_of_joining;
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

        public String getDid() {
            return did;
        }

        public void setDid(String did) {
            this.did = did;
        }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}


