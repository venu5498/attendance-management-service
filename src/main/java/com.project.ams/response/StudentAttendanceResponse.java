package com.project.ams.response;

public class StudentAttendanceResponse {



        private String id;
        private double percentage;
        private int totalClasses;
        private int attendedClasses;
        private String studentId;
        private String subjectId;

        public StudentAttendanceResponse() {
        }

        public StudentAttendanceResponse(String id,double percentage, int totalClasses, int attendedClasses, String studentId, String subjectId) {
            this.id=id;
            this.percentage = percentage;
            this.totalClasses = totalClasses;
            this.attendedClasses = attendedClasses;
            this.studentId = studentId;
            this.subjectId = subjectId;
        }


        public double getPercentage() {
            return percentage;
        }

        public void setPercentage(double percentage) {
            this.percentage = percentage;
        }

        public int getTotalClasses() {
            return totalClasses;
        }

        public void setTotalClasses(int totalClasses) {
            this.totalClasses = totalClasses;
        }

        public int getAttendedClasses() {
            return attendedClasses;
        }

        public void setAttendedClasses(int attendedClasses) {
            this.attendedClasses = attendedClasses;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getSubjectId() {
            return subjectId;
        }

        public void setSubjectId(String subjectId) {
            this.subjectId = subjectId;
        }
    }

