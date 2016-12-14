package com.nick.java8.learning.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

/**
 * Created by nick on 2016/12/6.
 * @author nick
 */
@Data
@Entity
@Table(name = "tb_teacher")
public class Student extends AbstractPersistable<String>{

    @Id
    @GeneratedValue(generator = "studentIdGenerator")
    @GenericGenerator(name="studentIdGenerator",strategy = "uuid")
    private String id;
    @Column(name = "teacher_id")
    private String teacherId;
    private String studentName;
    private String className;

}
