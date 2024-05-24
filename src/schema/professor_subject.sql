CREATE TABLE professor_subject{
    id VARCHAR(255) PRIMARY KEY,
    professor_id VARCHAR(255) NOT NULL,
    section_id VARCHAR(20) NOT NULL,
    subject_id VARCHAR(20) NOT NULL
}