package com.nick.java8.learning.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by nick on 2016/12/6.
 * @author nick
 */
@Data
@Entity
@Table(name = "tb_teacher")
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(generator = "teacherIdGenerator")
    @GenericGenerator(name="teacherIdGenerator",strategy = "uuid")
    private String id;
    @Column(name = "teacher_name")
    private String teacherName;
    @Column(name = "class_name")
    private String className;
    @Column(name = "gender")
    private String gender;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    private List<Student> students;

    public Teacher(){}

    public Teacher(String teacherName, String className, String gender){
        this.teacherName = teacherName;
        this.className = className;
        this.gender = gender;
    }

}
