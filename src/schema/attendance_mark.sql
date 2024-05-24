CREATE TABLE attendance_mark{
   id VARCHAR(255) PRIMARY KEY,
   date_of_attendance date NOT NULL,
   student_id VARCHAR(255) NOT NULL,
   subject_id VARCHAR(20) NOT NULL,
   section_id VARCHAR(20) NOT NULL,
   professor_id VARCHAR(255) NOT NULL,
   attendance_status VARCHAR(10)
};