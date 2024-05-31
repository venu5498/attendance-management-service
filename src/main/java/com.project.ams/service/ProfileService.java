package com.project.ams.service;

import com.project.ams.entity.Professor;
import com.project.ams.entity.Student;
import com.project.ams.jpa.ProfessorProfileRepository;
import com.project.ams.jpa.StudentProfileRepository;
import com.project.ams.request.ProfessorProfileRequest;
import com.project.ams.request.StudentProfileRequest;
import com.project.ams.response.ProfessorProfileResponse;
import com.project.ams.response.StudentProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    StudentProfileRepository studentProfileRepository;

    @Autowired
    ProfessorProfileRepository professorProfileRepository;

    public StudentProfileResponse getStudentProfile(String studentId) {
        Student student = studentProfileRepository.findStudentProfileByStudentId(studentId);
        System.out.println("Student found with ID: " + studentId +" is "+student);
        if (student == null) {
            return new StudentProfileResponse();
        }
        return createStudentProfileResponse(student);
    }

    public StudentProfileResponse createStudentProfile(StudentProfileRequest studentProfileRequest) {
        Student student = new Student();
        student.setAddress(studentProfileRequest.getAddress());
        student.setDept(studentProfileRequest.getDept());
        student.setDob(studentProfileRequest.getDob());
        student.setName(studentProfileRequest.getName());
        student.setEmail(studentProfileRequest.getEmail());
        student.setCurrent_year(studentProfileRequest.getCurrent_year());
        student.setFather_name(studentProfileRequest.getFather_name());
        student.setMother_name(studentProfileRequest.getMother_name());
        student.setMobileNumber(studentProfileRequest.getMobileNumber());
        student.setSectionId(studentProfileRequest.getSectionId());
        student = studentProfileRepository.save(student);

        return createStudentProfileResponse(student);
    }

    public Student createStudent(Student student) {

        student = studentProfileRepository.save(student);
        System.out.println("Student created with ID: " + student.getId());
        return  student;
    }


    private StudentProfileResponse createStudentProfileResponse(Student student) {
        StudentProfileResponse studentProfileResponse = new StudentProfileResponse();
        studentProfileResponse.setId(student.getId());
        studentProfileResponse.setAddress(student.getAddress());
        studentProfileResponse.setDept(student.getDept());
        studentProfileResponse.setDob(student.getDob());
        studentProfileResponse.setName(student.getName());
        studentProfileResponse.setEmail(student.getEmail());
        studentProfileResponse.setCurrent_year(student.getCurrent_year());
        studentProfileResponse.setFather_name(student.getFather_name());
        studentProfileResponse.setMother_name(student.getMother_name());
        studentProfileResponse.setMobileNumber(student.getMobileNumber());
        studentProfileResponse.setSectionId(student.getSectionId());
        return studentProfileResponse;
    }

    public ProfessorProfileResponse getProfessorProfile(String professorId) {
        Professor professor = professorProfileRepository.findProfessorProfileByProfessorId(String.valueOf(professorId));
        if (professor == null) {
            return new ProfessorProfileResponse();
        }
        return createProfessorProfileResponse(professor);
    }

    public ProfessorProfileResponse createProfessorProfile(ProfessorProfileRequest professorProfileRequest) {
        Professor professor = new Professor();
        professor.setAddress(professorProfileRequest.getAddress());
        professor.setDept(professorProfileRequest.getDept());
        professor.setDob(professorProfileRequest.getDob());
        professor.setName(professorProfileRequest.getName());
        professor.setEmail(professorProfileRequest.getEmail());
        professor.setDate_of_joining(professorProfileRequest.getDate_of_joining());
        professor.setFather_name(professorProfileRequest.getFather_name());
        professor.setMother_name(professorProfileRequest.getMother_name());
        professor.setMobileNumber(professorProfileRequest.getMobileNumber());
        professor.setDid(professorProfileRequest.getDid());

        professor = professorProfileRepository.save(professor);

        return createProfessorProfileResponse(professor);
    }


    private ProfessorProfileResponse createProfessorProfileResponse(Professor professor) {
        ProfessorProfileResponse professorProfileResponse = new ProfessorProfileResponse();
        professorProfileResponse.setId(professor.getId());
        professorProfileResponse.setAddress(professor.getAddress());
        professorProfileResponse.setDept(professor.getDept());
        professorProfileResponse.setDob(professor.getDob());
        professorProfileResponse.setName(professor.getName());
        professorProfileResponse.setEmail(professor.getEmail());
        professorProfileResponse.setDate_of_joining(professor.getDate_of_joining());
        professorProfileResponse.setFather_name(professor.getFather_name());
        professorProfileResponse.setMother_name(professor.getMother_name());
        professorProfileResponse.setMobileNumber(professor.getMobileNumber());
        professorProfileResponse.setDid(professor.getDid());
        return professorProfileResponse;
    }
}
