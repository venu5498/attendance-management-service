CREATE TABLE leave{
   id VARCHAR(255) PRIMARY KEY,
   type VARCHAR(255) NOT NULL,
   body VARCHAR(255) NOT NULL,
   requester_id VARCHAR(255),
   approval_id VARCHAR(255) ,
   leave_status VARCHAR(10),
   comments VARCHAR(255)

};