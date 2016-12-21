package com.nick.java8.learning.service;

import com.nick.java8.learning.domain.Course;

/**
 * Created by nick on 2016/12/21.
 */
public interface CourseFactory {

    Course buildCourse(String courseName, int period);
}
