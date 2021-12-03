package com.springdata.demo.repository;

import com.springdata.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

     List<Student> findByFirstName(String firstName);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);


    //JPQL
    @Query("select s from Student s where s.emailId= ?1")
    Student getStudentByEmailAddress(String emailId);


    //JPQL
    @Query("select s.firstName from Student s where s.emailId= ?1")
    String getStudentFirstNaByEmailAddress(String emailId);

    List<Student> findByFirstNameContaining(String name);
}
