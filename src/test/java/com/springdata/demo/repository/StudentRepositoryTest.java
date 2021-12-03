package com.springdata.demo.repository;

import com.springdata.demo.entity.Guardian;
import com.springdata.demo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder().
                emailId("jagadish@gmail.com")
                .firstName("Jaggu")
                .lastName("b")
               // .guardianEmail("guard@gmail.com")
               // .guardianName("guard")
                //.guradianMobile("222222")
                .build();
        studentRepository.save(student);
    }


    @Test
    public void print(){
        List<Student> list = studentRepository.findAll();
        System.out.println(list);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> list = studentRepository.findByFirstName("Jaggu");
        System.out.println(list);
    }
    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> list = studentRepository.findByFirstNameContaining("Jaggu");
        System.out.println(list);
    }

    @Test
    public void printStudentByGuardianName(){
        List<Student> list = studentRepository.findByGuardianName("britney");
        System.out.println(list);
    }



    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .email("guard@gmail.com")
                .mobile("78955")
                .name("britney")
                .build();

        Student student = Student.builder()
                .firstName("selena")
                .lastName("gomez")
                .emailId("selena@google.com")
                .guardian(guardian)
                .build();

    studentRepository.save(student);
    }


    @Test
    public void getStudentByEmailAddress(){

        Student student = studentRepository.getStudentByEmailAddress("selena@google.com");
        System.out.println(student);
    }


    @Test
    public void getStudentFirstNaByEmailAddress(){

        String student = studentRepository.getStudentFirstNaByEmailAddress("selena@google.com");
        System.out.println(student);
    }



}