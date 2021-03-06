package com.nick.java8.learning.test;

import com.nick.java8.learning.ApplicationStartup;
import com.nick.java8.learning.entity.Course;
import com.nick.java8.learning.entity.Student;
import com.nick.java8.learning.entity.Teacher;
import com.nick.java8.learning.service.EducationServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2016/12/21.
 * @author nick
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationStartup.class})
public class EducationServicesTest {

    @Autowired
    private EducationServices educationServices;

    @Test
    public void stream(){
        educationServices.stream();
    }

    @Test
    public void saveStudent(){
        Teacher teacher = educationServices.getRandomTeacher();
        educationServices.createStu("张三","班级15",teacher.getId(),22);
    }

    @Test
    public void saveCourse(){
        Course course = educationServices.createCour("高等数学", 2);
        Student student = educationServices.getRandomStudent();
        List<Course> courses = new ArrayList();
        courses.add(course);
        student.setCourses(courses);
        educationServices.updateStudent(student);
    }

    @Test
    public void saveTeacher(){
        Teacher teacher = educationServices.createTeach("王晓丽","高二(4)班","female");
        System.out.println(teacher.getTeacherName());
    }
}
