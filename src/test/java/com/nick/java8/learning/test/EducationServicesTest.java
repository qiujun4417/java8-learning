package com.nick.java8.learning.test;

import com.nick.java8.learning.ApplicationStartup;
import com.nick.java8.learning.domain.Teacher;
import com.nick.java8.learning.service.EducationServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by nick on 2016/12/21.
 * @author nick
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationStartup.class})
public class EducationServicesTest {

    @Autowired
    private EducationServices educationServices;


    @Test
    public void serviceTest(){
        Teacher teacher = educationServices.getRandomTeacher();
        educationServices.createStu("张三","班级15",teacher.getId(),22);
    }
}
