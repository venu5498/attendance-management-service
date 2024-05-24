package com.project.ams.service;

import com.project.ams.entity.Professor;
import com.project.ams.entity.Section;
import com.project.ams.entity.Student;
import com.project.ams.entity.Subject;
import com.project.ams.jpa.ProfessorProfileRepository;
import com.project.ams.jpa.SectionRepository;
import com.project.ams.jpa.StudentProfileRepository;
import com.project.ams.jpa.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataPopulatorService {

    @Autowired
    ProfessorProfileRepository professorProfileRepository;
    @Autowired
    SectionRepository sectionRepository;
    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    StudentProfileRepository studentProfileRepository;

    public void populateDummyData() {
        // Create Dummy professors
        List<String> professorsList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Professor professor = new Professor();
            professor.setName("Professor" + i);
            professor.setAddress("Hyderabad");
            professor.setDept("IT");
            professor.setDate_of_joining(LocalDate.now().minusYears(5));
            professor.setEmail("professor" + i + "@cvr.com");
            professor.setMobileNumber("9849353680");
            professor = professorProfileRepository.save(professor);
            professorsList.add(professor.getId());
        }

        // Create Dummy sections
        List<String> sectionsList = new ArrayList<>();
        for (int i = 0; i < professorsList.size(); i++) {
            Section section = new Section("IT_" + i, professorsList.get(i));
            section = sectionRepository.save(section);
            sectionsList.add(section.getId());
        }

        // Create Dummy sections
        List<String> subjectsList = new ArrayList<>();
        for (int i = 0; i < sectionsList.size(); i++) {
            Subject subject = new Subject("DSA_" + i, sectionsList.get(i));
            subject = subjectRepository.save(subject);
            subjectsList.add(subject.getId());
        }

        List<String> studentsList = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            Student student = new Student();
            student.setName("Student_" + j);
            student.setEmail("Student_" + j + "@cvr.com");
            student.setDob(LocalDate.now().minusYears(20));
            student.setDept("CSE");
            student.setAddress("Hyderabad");
            student.setCurrent_year(2);
            student.setMobileNumber("9876543210");
            student.setFather_name("Clark Kent");
            student.setMother_name("Princess Diana");

            student.setName("Student_" + j);
            for (int i = 0; i < sectionsList.size(); i++) {
                student.setSectionId(sectionsList.get(i));
                student = studentProfileRepository.save(student);
                studentsList.add(student.getId());
            }
        }


        System.out.println("Created Dummy professors list: " + professorsList);
        System.out.println("Created Dummy sections list: " + sectionsList);
        System.out.println("Created Dummy subjects list: " + subjectsList);
        System.out.println("Created Dummy students list: " + studentsList);
    }

    public void professorData() {

        List<String> professorsList = new ArrayList<>();

        Professor p1 = new Professor();
        p1.setId("P12345678");
        p1.setName("A.MallaReddy");
        p1.setAddress("Hyderabad");
        p1.setDept("IT");
        p1.setDate_of_joining(LocalDate.of(2017, 4, 21));
        p1.setEmail("mallareddy123@gmail.com");
        p1.setMobileNumber("9849353680");
        p1 = professorProfileRepository.save(p1);
        professorsList.add(p1.getId());

        Professor p2 = new Professor();
        p2.setId("P23456789");
        p2.setName("Soma");
        p2.setAddress("Hyderabad");
        p2.setDept("IT");
        p2.setDate_of_joining(LocalDate.of(2017, 4, 21));
        p2.setEmail("somaphy123@gmail.com");
        p2.setMobileNumber("9849353680");
        p2 = professorProfileRepository.save(p2);
        professorsList.add(p2.getId());

        Professor p3 = new Professor();
        p3.setId("P34567890");
        p3.setName("Vimala");
        p3.setAddress("Hyderabad");
        p3.setDept("IT");
        p3.setDate_of_joining(LocalDate.of(2016, 6, 01));
        p3.setEmail("vimala123@gmail.com");
        p3.setMobileNumber("9848853680");
        p3 = professorProfileRepository.save(p3);
        professorsList.add(p3.getId());

        Professor p4 = new Professor();
        p4.setId("P45678901");
        p4.setName("Swathi");
        p4.setAddress("Hyderabad");
        p4.setDept("IT");
        p4.setDate_of_joining(LocalDate.of(2013, 9, 28));
        p4.setEmail("swathi123@gmail.com");
        p4.setMobileNumber("9848853680");
        p4 = professorProfileRepository.save(p4);
        professorsList.add(p4.getId());

        Professor p5 = new Professor();
        p5.setId("P56789012");
        p5.setName("jaheda");
        p5.setAddress("Hyderabad");
        p5.setDept("IT");
        p5.setDate_of_joining(LocalDate.of(2012, 10, 28));
        p5.setEmail("jaheda@gmail.com");
        p5.setMobileNumber("9848853680");
        p5 = professorProfileRepository.save(p5);
        professorsList.add(p5.getId());

        System.out.println("Created Dummy professors list: " + professorsList);

    }

    public void studentData() {
        List<String> studentList = new ArrayList<>();

        Student s1 = new Student();
        s1.setName("Sathvik");
        s1.setId("22B81A12B3");
        s1.setEmail("sathvik123@gmail.com");
        s1.setDob(LocalDate.of(2004, 8, 2));
        s1.setDept("IT");
        s1.setAddress("Hyderabad");
        s1.setCurrent_year(2);
        s1.setMobileNumber("9876543900");
        s1.setFather_name("Anand");
        s1.setMother_name("Jyothi");
        s1 = studentProfileRepository.save(s1);
        studentList.add(s1.getId());


        Student s2 = new Student();
        s2.setName("Dhruva");
        s2.setId("22B81A12A9");
        s2.setEmail("dhruva123@gmail.com");
        s2.setDob(LocalDate.of(2005, 3, 11));
        s2.setDept("IT");
        s2.setAddress("Hyderabad");
        s2.setCurrent_year(2);
        s2.setMobileNumber("9876567676");
        s2.setFather_name("Sridhar");
        s2.setMother_name("Kavitha");
        s2 = studentProfileRepository.save(s2);
        studentList.add(s2.getId());

        Student s3 = new Student();
        s3.setName("T.VenuGopal");
        s3.setId("22B81A12C8");
        s3.setEmail("venugopal123@gmail.com");
        s3.setDob(LocalDate.of(2005, 2, 28));
        s3.setDept("IT");
        s3.setAddress("Hyderabad");
        s3.setCurrent_year(2);
        s3.setMobileNumber("9392858496");
        s3.setFather_name("Satyanarayana");
        s3.setMother_name("Geetha");
        s3 = studentProfileRepository.save(s3);
        studentList.add(s3.getId());

        Student s4 = new Student();
        s4.setName("Ujwala");
        s4.setId("22B81A12C2");
        s4.setEmail("ujwala123@gmail.com");
        s4.setDob(LocalDate.of(2004, 9, 24));
        s4.setDept("IT");
        s4.setAddress("Hyderabad");
        s4.setCurrent_year(2);
        s4.setMobileNumber("9392858456");
        s4.setFather_name("Rajender");
        s4.setMother_name("Usha");
        s4 = studentProfileRepository.save(s4);
        studentList.add(s4.getId());

        Student s5 = new Student();
        s5.setName("Vaishnavi");
        s5.setId("22B81A12C3");
        s5.setEmail("vaishu123@gmail.com");
        s5.setDob(LocalDate.of(2005, 2, 5));
        s5.setDept("IT");
        s5.setAddress("Hyderabad");
        s5.setCurrent_year(2);
        s5.setMobileNumber("9562858456");
        s5.setFather_name("Hanmanth Rao");
        s5.setMother_name("Anitha");
        s5 = studentProfileRepository.save(s5);
        studentList.add(s5.getId());

        System.out.println("Created Dummy studentList : " + studentList);
    }

    public void sectionData() {
        List<String> sectionsList = new ArrayList<>();

        Section sec1 = new Section();
        sec1.setId("IT12");
        sec1.setName("IT-A");
        sec1.setProfessor_id("P56789012");
        sec1 = sectionRepository.save(sec1);
        sectionsList.add(sec1.getId());

        Section sec2 = new Section();
        sec2.setId("IT23");
        sec2.setName("IT-B");
        sec2.setProfessor_id("P34567890");
        sec2 = sectionRepository.save(sec2);
        sectionsList.add(sec2.getId());

        Section sec3 = new Section();
        sec3.setId("IT34");
        sec3.setName("IT-C");
        sec3.setProfessor_id("P12345678");
        sec3 = sectionRepository.save(sec3);
        sectionsList.add(sec3.getId());

        Section sec4 = new Section();
        sec4.setId("IT45");
        sec4.setName("IT-D");
        sec4.setProfessor_id("P23456789");
        sec4 = sectionRepository.save(sec4);
        sectionsList.add(sec4.getId());

        Section sec5 = new Section();
        sec5.setId("IT56");
        sec5.setName("IT-E");
        sec5.setProfessor_id("P45678901");
        sec5 = sectionRepository.save(sec5);
        sectionsList.add(sec5.getId());

        System.out.println("Created Dummy sectionsList : " + sectionsList);
    }

    public void subjectData() {

        List<String> subjectsList = new ArrayList<>();

        Subject sub1 = new Subject();
        sub1.setId("DSA123");
        sub1.setName("DSA");
        sub1.setSection_id("IT-A");
        sub1 = subjectRepository.save(sub1);
        subjectsList.add(sub1.getId());

        Subject sub2 = new Subject();
        sub2.setId("Maths123");
        sub2.setName("Maths");
        sub2.setSection_id("IT-B");
        sub2 = subjectRepository.save(sub2);
        subjectsList.add(sub2.getId());


        createSubjectData("Maths123", "Python", "IT-C", subjectsList);
        createSubjectData("Science123", "ComputerOrganization", "IT-D", subjectsList);


        System.out.println("Created Dummy subjectsList : " + subjectsList);

    }

    public void createSubjectData(String id, String name, String sectionId, List<String> subjectsList) {

        Subject sub = new Subject();
        sub.setId(id);
        sub.setName(name);
        sub.setSection_id(sectionId);
        sub = subjectRepository.save(sub);
        subjectsList.add(sub.getId());

    }


}
