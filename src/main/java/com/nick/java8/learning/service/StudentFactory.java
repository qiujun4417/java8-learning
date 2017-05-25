package com.nick.java8.learning.service;

import com.nick.java8.learning.entity.Student;

/**
 * Created by nick on 2016/12/20.
 * @author nick
 */
public interface StudentFactory {
    Student buildStudent(String name, String className, String teacherId, int age);
}
