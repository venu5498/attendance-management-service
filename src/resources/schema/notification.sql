CREATE TABLE notification{
      id VARCHAR(255) PRIMARY KEY,
      body VARCHAR(255) NOT NULL,
      sender_id VARCHAR(255) NOT NULL,
      receiver_id VARCHAR(255) NOT NULL
}