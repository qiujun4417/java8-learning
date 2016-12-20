package com.nick.java8.learning.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by nick on 2016/12/6.
 * @author nick
 */
@Data
@Entity
@Table(name = "tb_student")
public class Student implements Serializable{

    @Id
    @GeneratedValue(generator = "studentIdGenerator")
    @GenericGenerator(name="studentIdGenerator",strategy = "uuid")
    private String id;
    @Column(name = "teacher_id")
    private String teacherId;
    @Column(name = "student_name")
    private String studentName;
    @Column(name="class_name")
    private String className;
    @NotNull
    private int age;

    public Student(){

    }

    public Student(String teacherId, String studentName, String className, int age){
        this.teacherId = teacherId;
        this.studentName = studentName;
        this.className = className;
        this.age = age;
    }

}
