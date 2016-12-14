package com.nick.java8.learning.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by nick on 2016/12/6.
 * @author nick
 */
@Data
@Entity
@Table(name = "tb_teacher")
public class Teacher extends AbstractPersistable<String> {

    @Id
    @GeneratedValue(generator = "teacherIdGenerator")
    @GenericGenerator(name="teacherIdGenerator",strategy = "uuid")
    private String id;
    private String teacherName;
    private String className;
    private String gender;
}
