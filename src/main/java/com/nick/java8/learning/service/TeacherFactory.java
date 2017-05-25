package com.nick.java8.learning.service;

import com.nick.java8.learning.entity.Teacher;

/**
 * Created by nick on 2016/12/20.
 */
@FunctionalInterface
public interface TeacherFactory {

    Teacher buildTeacher(String teacherName, String className, String gender);

}
