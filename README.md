# attendance-management-service
This is used for managing attendance in college for students , staff etc .  

###Database
For the time being, we are using H2 as our RDBMS. However, this can be easily replaced by PostgreSQL in a production environment.

### Code Comments

We have added comments to each important class and method to ensure easy understanding and maintainability of the codebase.

### Steps to Test
1. **Run the Application**:Start your Spring Boot application by running the main method in your main application class. This will launch the embedded server (e.g., Tomcat) and deploy the application.
Ensure the application starts successfully and the server is running on the configured port (default is 8080).
2. **Open Postman**:Launch Postman on your computer to prepare for sending requests to your application.
3. **Configure Requests**:Set up the request URL: Use the appropriate URL for the API endpoint you want to test. For example, http://localhost:8080/api/students for student-related endpoints.
Select the HTTP method: Choose the correct HTTP method (GET, POST, PUT, DELETE) based on the operation you want to perform.

---


## Low Level Design approach :

### Entities:
- Student
- professor
- Attendance
- AttendanceRegister
- Leave
- Section
- Subject

## Requirements/ Use case diagrams:

###  Student:

- login
- register
- view profile
- view attendance
- apply for leave

##  Professor:

-login
-register
-get active sections
-get active subjects
-get students list
-mark attendance

##  Approver

-takes action on leaveletter
-view attendance

---

## Class:

- student
- attendance
- attendanceRegister
- leave
- section
- subject
- Professor

---

## Service Level Classes:

- ## Service Level Classes:

- InventoryManager
- StoreManager
- RestockingManager
- ProductManager
- StoreManager
- RestockingManager
- ProductManager

  




