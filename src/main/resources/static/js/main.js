

function showForm(formId) {
    var createStudentForm = document.getElementById('createStudentForm');
    var getStudentForm = document.getElementById('getStudentForm');

    // Initially hide both forms
    createStudentForm.style.display = 'none';
    getStudentForm.style.display = 'none';

    // Show the form that corresponds to the clicked button
    var form = document.getElementById(formId);
    form.style.display = 'block';
}

document.getElementById('studentIdForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the form from submitting normally

    var studentId = document.getElementById('studentIdInput').value; // Get the input value

    // Make a GET request to the ProfileController endpoint
    fetch('/student/' + studentId, {
        method: 'GET',
    })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            // Display the student data
            // This will depend on how you want to display the data on your page
        })
        .catch((error) => {
            console.error('Error:', error);
        });
});

function enterAsProfessor() {

    var professorId = prompt("Please enter your professor ID:");
    // Clear the contents of the professorOptions div
    document.getElementById('professorSectionList').innerHTML = '';
    document.getElementById('studentDetails').innerHTML = '';
    document.getElementById('studentAttendance').innerHTML = '';

    if (professorId != null) {
        fetch('/sections/active?professorId=' + professorId)
            .then(response => response.json())
            .then(data => {
                var sectionList = document.getElementById('professorSectionList');
                sectionList.innerHTML = '';
                data.forEach(section => {

                    // Create a div for each section
                    var sectionDiv = document.createElement('div');
                    sectionDiv.className = 'section';

                    // Create a p element for the section details
                    var p = document.createElement('p');
                    p.className = 'section-details';
                    p.textContent = 'Section ID: ' + section.id + ', Section Name: ' + section.name;
                    sectionDiv.appendChild(p);

                    // Create a "Get Subjects" button for each section
                    var button = document.createElement('button');
                    button.className = 'get-subjects-btn';
                    button.textContent = 'Get Subjects';
                    button.onclick = function() {
                        getSubjects(section.id);
                    };
                    sectionDiv.appendChild(button);

                    // Append the section div to the section list
                    sectionList.appendChild(sectionDiv);
                });
                sectionList.style.display = 'block';
            });
    }
}

function getSubjects(sectionId) {
    console.log('getSubjects called with sectionId:', sectionId); // Debug line

    fetch('/subject/active?sectionId=' + sectionId)
        .then(response => response.json())
        .then(data => {
            var subjectList = document.getElementById('subjectList');
            subjectList.innerHTML = ''; // Clear the list before appending new subjects
            data.forEach(subject => {

                // Create a div for each subject
                var subjectDiv = document.createElement('div');
                subjectDiv.className = 'subject';

                // Create a p element for the subject details
                var p = document.createElement('p');
                p.className = 'subject-details';
                p.textContent = 'Subject ID: ' + subject.id + ', Subject Name: ' + subject.name;
                subjectDiv.appendChild(p);

                // Create a "Get Students" button for each subject
                var button = document.createElement('button');
                button.className = 'get-students-btn';
                button.textContent = 'Get Students';
                button.onclick = function() {
                    getStudents(sectionId, subject.id);
                };
                subjectDiv.appendChild(button);

                // Append the subject div to the subject list
                subjectList.appendChild(subjectDiv);
            });
            subjectList.style.display = 'block';
        });
}

function getStudents(sectionId,subjectId) {

    fetch('/student/bySection?sectionId=' + sectionId)
        .then(response => response.json())
        .then(data => {
            var studentList = document.getElementById('studentList');
            studentList.innerHTML = ''; // Clear the list before appending new students

            // Create a table
            var table = document.createElement('table');
            table.className = 'student-table';

            // Create a header row
            var headerRow = document.createElement('tr');
            ['Student ID', 'Student Name', 'Mark Present'].forEach(text => {
                var th = document.createElement('th');
                th.textContent = text;
                headerRow.appendChild(th);
            });
            table.appendChild(headerRow);

            data.forEach(student => {
                // Create a row for each student
                var tr = document.createElement('tr');

                // Create a cell for the student ID
                var idTd = document.createElement('td');
                idTd.textContent = student.id;
                tr.appendChild(idTd);

                // Create a cell for the student name
                var nameTd = document.createElement('td');
                nameTd.textContent = student.name;
                tr.appendChild(nameTd);

                // Create a cell for the checkbox
                var checkboxTd = document.createElement('td');
                var checkbox = document.createElement('input');
                checkbox.type = 'checkbox';
                checkbox.id = student.id;
                checkbox.name = 'student';
                checkbox.value = student.id;
                checkbox.className = 'student-checkbox';
                checkboxTd.appendChild(checkbox);
                tr.appendChild(checkboxTd);

                // Append the row to the table
                table.appendChild(tr);
            });

            // Append the student div to the student list
            studentList.appendChild(table);

            // Create a submit button
            var button = document.createElement('button');
            button.className = 'submit-attendance-btn';
            button.textContent = 'Submit Attendance';
            button.onclick = function() {
                // Gather all student IDs
                var allStudents = Array.from(document.querySelectorAll('input[name="student"]')).map(checkbox => checkbox.value);
                var attendanceStatusMap = allStudents.reduce((acc, studentId) => {
                    // Check if the student is present
                    var isPresent = document.getElementById(studentId).checked;
                    acc[studentId] = isPresent ? "PRESENT" : "ABSENT";
                    return acc;
                }, {});

                // Create an instance of MarkAttendanceRequest
                var markAttendanceRequest = {
                    dateOfAttendance: new Date().toISOString().split('T')[0], // Current date in YYYY-MM-DD format
                    sectionId: sectionId,
                    subjectId: subjectId, // Replace with the actual subject ID
                    attendanceStatusMap: attendanceStatusMap,
                    professorId: 'professorId' // Replace with the actual professor ID
                };

                console.log('markAttendanceRequest:', markAttendanceRequest); // Debug line

                // Make a POST request to the markAttendance endpoint
                fetch('/attendance/mark', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify(markAttendanceRequest),
                })
                    .then(response => response.json())
                    .then(data => {
                        console.log('Success:', data);
                        // Create a success message
                        var successMessage = document.createElement('p');
                        successMessage.className = 'success-message';
                        successMessage.textContent = 'Submitted attendance successfully!';
                        studentList.appendChild(successMessage);
                    })
                    .catch((error) => {
                        console.error('Error:', error);
                    });
            };
            studentList.appendChild(button);
            studentList.style.display = 'block';
        });
}

// Add event listener to the getStudentForm
function getStudentForm() {
    // this is sparta
    var studentId = document.getElementById('studentId').value;
    console.log('studentId:', studentId); // Debug line
    // Make a GET request to the /student/{studentId} endpoint
    fetch('/student/' + studentId, {
        method: 'GET',
    })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            // Display the student data
        })
        .catch((error) => {
            console.error('Error:', error);
        });
}

var studentId; // Global variable to store the studentId

function enterAsStudent() {
    studentId = prompt("Please enter your student ID:");
    if (studentId != null) {

        // Clear the professor data
        document.getElementById('professorSectionList').innerHTML = '';
        document.getElementById('subjectList').innerHTML = '';
        document.getElementById('studentList').innerHTML = '';
        document.getElementById('studentAttendance').innerHTML = '';

        document.getElementById('studentOptions').style.display = 'block';
        document.getElementById('studentIdDisplay').textContent = 'Student ID: ' + studentId;
    }
}

window.onload = function() {
    // Your code here
    document.getElementById('applyForLeave').onclick = function() {
        document.getElementById('applyLeaveForm').style.display = 'block';
    };
}

function getAttendance() {
    // Make a GET request to the getStudentAttendance endpoint
    console.log('studentId:', studentId); // Debug line
    fetch(`/attendance/${studentId}`, {
        method: 'GET',
    })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            var studentAttendance = document.getElementById('studentAttendance');
            studentAttendance.innerHTML = ''; // Clear the list before appending new attendance data

            // Create a div for the attendance data
            var attendanceDataDiv = document.createElement('div');
            attendanceDataDiv.className = 'attendance-data';

            // Create a p element for each piece of attendance data
            var percentageP = document.createElement('p');
            percentageP.className = 'attendance-percentage';
            percentageP.textContent = 'Percentage: ' + data.percentage;
            attendanceDataDiv.appendChild(percentageP);

            var totalClassesP = document.createElement('p');
            totalClassesP.className = 'attendance-total-classes';
            totalClassesP.textContent = 'Total Classes: ' + data.totalClasses;
            attendanceDataDiv.appendChild(totalClassesP);

            var attendedClassesP = document.createElement('p');
            attendedClassesP.className = 'attendance-attended-classes';
            attendedClassesP.textContent = 'Attended Classes: ' + data.attendedClasses;
            attendanceDataDiv.appendChild(attendedClassesP);

            var subjectIdP = document.createElement('p');
            subjectIdP.className = 'attendance-subject-id';
            subjectIdP.textContent = 'Subject ID: ' + data.subjectId;
            attendanceDataDiv.appendChild(subjectIdP);

            // Append the attendance data div to the student attendance div
            studentAttendance.appendChild(attendanceDataDiv);
            studentAttendance.style.display = 'block';
        })
        .catch((error) => {
            console.error('Error:', error);
        });
}

function leaveForm() {

    // Create the leaveRequest object
    var leaveRequest = {
        requesterId: '{studentId}', // Replace with the actual student ID
        body: document.getElementById('body').value,
        type: document.getElementById('type').value,
        approverId: document.getElementById('approverId').value
    };

    // Make a POST request to the applyForLeave endpoint
    fetch('/leave/apply', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(leaveRequest),
    })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            // Display the leave application status
        })
        .catch((error) => {
            console.error('Error:', error);
        });
}

function getLeaves() {
    // Make a GET request to the getLeaves endpoint
    fetch('/leave/requester?requesterId=\' + studentId', {
        method: 'GET',
    })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            // Display the leave data
        })
        .catch((error) => {
            console.error('Error:', error);
        });
}