package com.nick.soa.service.register.annotation;

import java.lang.annotation.*;

/**
 * Created by nick on 2017/6/23.
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SoaService {

    String value();
}
