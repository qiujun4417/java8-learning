package com.nick.java8.learning.repository;

import com.nick.java8.learning.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nick on 2016/12/21.
 */
public interface CourseRepository extends JpaRepository<Course, String>{
}
