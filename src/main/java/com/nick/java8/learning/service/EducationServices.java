package com.nick.java8.learning.service;

import com.google.common.base.Supplier;
import com.nick.java8.learning.domain.Course;
import com.nick.java8.learning.domain.Student;
import com.nick.java8.learning.domain.Teacher;
import com.nick.java8.learning.repository.CourseRepository;
import com.nick.java8.learning.repository.StudentRepository;
import com.nick.java8.learning.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * Created by nick on 2016/12/20.
 */
@Service
public class EducationServices {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;

    private Student createStudent(String teacherId, String name, String className, int age){
        StudentFactory factory = Student::new;
        return factory.buildStudent(teacherId, name, className, age);
    }

    private Teacher createTeacher(String teacherName, String className, String gender){
        TeacherFactory factory = (a, b, c)->new Teacher(a, b, c);
        return factory.buildTeacher(teacherName, className, gender);
    }

    private Course createCourse(String courseName, int period){
        CourseFactory factory = (a, b)->{
            Supplier<Course> supplier = Course::new;
            return supplier.get();
        };
        return factory.buildCourse(courseName, period);
    }

    public Student createStu(String name, String className, String teacherId, int age){
        Student student = createStudent(teacherId, name, className, age);
        student = studentRepository.save(student);
        return student;
    }

    public Teacher createTeach(String teacherName, String className, String gender){
        Teacher teacher = createTeacher(teacherName, className, gender);
        teacher = teacherRepository.save(teacher);
        return teacher;
    }

    public Course createCour(String courseName, int period){
        Course course = createCourse(courseName, period);
        course = courseRepository.save(course);
        return course;
    }

    public Teacher getRandomTeacher(){
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.get(new Random().nextInt(100));
    }
}
