package com.nick.java8.learning.web;

import com.nick.java8.learning.domain.Student;
import com.nick.java8.learning.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by nick on 2016/12/16.
 * @author nick
 */
@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/api")
    @ResponseBody
    @Transactional
    public String addStudent(){
        Student student = new Student();
        studentRepository.save(student);
        return "";
    }
}