CREATE TABLE attendance{
   id VARCHAR(255) PRIMARY KEY,
    percentage DECIMAL(3, 1),
    total_classes  INT NOT NULL,
    attended_classes INT NOT NULL,
    student_id VARCHAR(255) NOT NULL,
    subject_id VARCHAR(20) NOT NULL
};