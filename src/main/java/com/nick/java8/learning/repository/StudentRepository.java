package com.nick.java8.learning.repository;

import com.nick.java8.learning.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nick on 2016/12/14.
 * @author nick
 */
public interface StudentRepository extends JpaRepository<Student, String>{

}
