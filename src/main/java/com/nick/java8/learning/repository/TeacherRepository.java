package com.nick.java8.learning.repository;

import com.nick.java8.learning.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nick on 2016/12/14.
 * @author nick
 */
public interface TeacherRepository extends JpaRepository<Teacher, String> {

}
