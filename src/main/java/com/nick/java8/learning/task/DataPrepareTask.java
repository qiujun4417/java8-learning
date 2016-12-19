package com.nick.java8.learning.task;

import com.nick.java8.learning.domain.Student;
import com.nick.java8.learning.domain.Teacher;
import com.nick.java8.learning.repository.StudentRepository;
import com.nick.java8.learning.repository.TeacherRepository;
import com.nick.java8.learning.utils.IDGen;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by nick on 2016/12/19.
 * @author nick
 */
@Component
public class DataPrepareTask implements InitializingBean{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        dataInit();
    }

    private void dataInit(){
        List<Teacher> teachers = new ArrayList<>();
        for(int i=0; i<1000; i++){
            Teacher teacher = new Teacher();
            teacher.setClassName("班级" + new Random().nextInt(100));
            teacher.setGender(new Random().nextInt(2)== 0 ? "male": "female");
            teacher.setId(IDGen.uuid());
            teacher.setTeacherName("张" + new Random().nextInt(100));
            teachers.add(teacher);
        }
        teacherRepository.save(teachers);

        List<Teacher> teacherList = teacherRepository.findAll();
        List<Student> students = new ArrayList<>();
        for(int i=0; i<10000; i++){
            Teacher teacher = teacherList.get(new Random().nextInt(100));
            Student student = new Student();
            student.setId(IDGen.uuid());
            student.setClassName(teacher.getClassName());
            student.setStudentName("学生" + i);
            student.setTeacherId(teacher.getId());
            students.add(student);
        }
        studentRepository.save(students);
    }
}
