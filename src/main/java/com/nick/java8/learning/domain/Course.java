package com.nick.java8.learning.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by nick on 2016/12/21.
 * @author nick
 */
@Data
@Entity
@Table(name = "tb_course")
public class Course {

    @Id
    @GeneratedValue(generator = "courseIdGenerator")
    @GenericGenerator(name="courseIdGenerator",strategy = "uuid")
    @Column(name = "course_id")
    private String courseId;
    @Column(name = "course_name")
    private String courseName;
    private int period; //0 09:00-09:45 1 10:00-10:45 2 11:00-11:45 3 14:00-14:45 4 15:00-15:45 5 16:00-16:45

    public Course(){}

    public Course(String courseName, int period){
        this.courseName = courseName;
        this.period = period;
    }
}
