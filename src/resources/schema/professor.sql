CREATE TABLE  professor{
       id VARCHAR(255) PRIMARY KEY,
       name VARCHAR(255) NOT NULL,
       email VARCHAR(255) NOT NULL,
       date_of_joining DATE,
       mobileNumber INT NOT NULL,
       dob DATE,
       father_name VARCHAR(255) NOT NULL,
       mother_name VARCHAR(255) NOT NULL,
       address VARCHAR(255) NOT NULL,
       did VARCHAR(20) NOT NULL
    };