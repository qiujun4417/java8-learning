package com.nick.java8.learning.service;

import com.nick.java8.learning.domain.Student;
import com.nick.java8.learning.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nick on 2016/12/20.
 */
@Service
public class StudentServices {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(String name, String className, String teacherId, int age){
        StudentFactory factory = Student::new;
        return factory.buidStudent(name, className, teacherId, age);
    }

}
