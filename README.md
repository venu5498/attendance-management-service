# Attendance-Management-Service
This is used for managing attendance in college for students , staff etc .  

### Database
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


## Tools :

  ### Backend

- Java spring boot, Spring mvc.
- maven.
- H2 hibernate.
- sql.
- RestApis.

  ### FrontEnd

- thymeleaf.
- Html, CSS, JavaScript.
  

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
  

---


## Requirements/ Use case diagrams:

###  Student:

- login
- register
- view profile
- view attendance
- apply for leave

###  Professor:

- login
- register
- get active sections
- get active subjects
- get students list
- mark attendance

###  Approver

- takes action on leaveletter
- view attendance

---

### Class:

- student
- attendance
- attendanceRegister
- leave
- section
- subject
- Professor

---

###  Service Level Classes:

- AttendanceService
- DataPopulatorService
- LeaveService
- ProfileService
- SectionService
- SubjectService
- StudentService
- ProfessorService
  
---

### DB:

- SQL:
    - Usage: Standard for managing relational databases.
    - Consistency: Provides strong consistency with ACID properties.
    - Type of Data: Ideal for structured data with clear relationships.
 
---

## User Activity Diagram:

### login:

1. User sends request with credentials.
2. First authenticate - if we are having the token info as part of request.
    - If no, return 401 saying unauthorized.
    - If yes, check if the user exists.
        - If no, return error saying invalid credentials.
        - If yes, create a token with permissions set.
          
     
### signup:

- Get all the details required such as name, email, password, etc.
- Validate request and if any error, send 400.
- Else, check for password validation.
    - If not okay, send 400.
- Else, create an entry in the DB and return 201.


### viewProfile:   

- View all details of that particular requester id i.e student or professor.
- Validate id and if any error, send 400.
- Else, get profile.

### viewAttendance:

- View attendance of that particular requester i.e student.
- Validate id and if any error, send 400.
- Else, get attendance.

### applyLeave:

- Apply for leave by providing reason and timeperiod.
- Send leaveletter to Hod.

### activeSections:

- Get active sections assigned to particular professor.
- validate professor id and if any error, send 400.
- Else, get active sections of that professor.

### activeSubjects:

- Get active subjects assigned to that particular professor and section.
- validate sectionId and if any error, send 400.
- Else, get active subjects of that section of that professor.

### activeStudents:

- Get active students of that section by providing subject id.
- Validate subjectId and if an error, send 400.
- Else, get active students list to mark attendance.

### markAttendance:

- mark attendance for students .
- select checkboxes if student is present.
- Else, leave empty.
- After marking the attendance, submit the attendance.

### activeLetters:

- Get active letters sent by requesters.
- Validate approverId and if an error , send 400.
- Else, view letters.

### leaveAction:

- Take action on leave letter sent by requester.
- Validate approverId and if an error , send 400.
- Else, take action on letter (Accept or Reject).

---








  




