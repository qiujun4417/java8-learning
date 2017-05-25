package com.nick.java8.learning.service;

import com.nick.java8.learning.entity.Course;
import com.nick.java8.learning.entity.Student;
import com.nick.java8.learning.entity.Teacher;
import com.nick.java8.learning.repository.CourseRepository;
import com.nick.java8.learning.repository.StudentRepository;
import com.nick.java8.learning.repository.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    private final Logger logger = LoggerFactory.getLogger(EducationServices.class);

    public void stream(){
        long curr = System.currentTimeMillis();
        List<Student> students = studentRepository.findAll();
//        List<Student> students1 = students.stream().filter((a) -> a.getAge() > 20 && a.getAge() < 30).
//                sorted((c, d) -> {
//                    if (c.getAge() > d.getAge()) return 1;
//                    else if (c.getAge() == d.getAge()) return 0;
//                    else return -1;
//                }).
//                collect(Collectors.toList());
        long count1 = students.parallelStream().filter((a)->a.getAge()>22).count();
        long end = System.currentTimeMillis();
        long cost = end - curr;
        logger.info("1.8jdk: the count of student whose age over 22 year old "
                + count1 + " and cost " + cost + " ms");
        students = studentRepository.findAll();
        curr = System.currentTimeMillis();
        List<Student> conditions = new ArrayList<>();
        for(Student student: students){
            if(student.getAge()>22)
                conditions.add(student);
        }
        end = System.currentTimeMillis();
        cost = end - curr;
        logger.info("1.7jdk: the count of student whose age over 22 year old " +
                conditions.size() + " and cost " + cost + " ms");

    }

    private Student createStudent(String teacherId, String name, String className, int age){
        StudentFactory factory = Student::new;
        return factory.buildStudent(teacherId, name, className, age);
    }

    private Teacher createTeacher(String teacherName, String className, String gender){
        TeacherFactory factory = (a, b, c)->new Teacher(a, b, c);
        return factory.buildTeacher(teacherName, className, gender);
    }

    private Course createCourse(String courseName, int period){
        CourseFactory factory = (a, b)-> new Course(a,b);
        return factory.buildCourse(courseName, period);
    }

    @Transactional
    public Student createStu(String name, String className, String teacherId, int age){
        Student student = createStudent(teacherId, name, className, age);
        student = studentRepository.save(student);
        return student;
    }

    @Transactional
    public Teacher createTeach(String teacherName, String className, String gender){
        Teacher teacher = createTeacher(teacherName, className, gender);
        teacher = teacherRepository.save(teacher);
        return teacher;
    }

    @Transactional
    public Course createCour(String courseName, int period){
        Course course = createCourse(courseName, period);
        course = courseRepository.save(course);
        return course;
    }

    public Teacher getRandomTeacher(){
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.get(new Random().nextInt(100));
    }

    public Student getRandomStudent(){
        List<Student> students = studentRepository.findAll();
        return students.get(new Random().nextInt(100));
    }

    @Transactional
    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    @Transactional
    public Teacher updateTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }
}
