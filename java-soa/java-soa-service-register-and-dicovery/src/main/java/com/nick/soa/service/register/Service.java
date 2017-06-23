package com.nick.soa.service.register;

import lombok.Data;

/**
 * Created by nick on 2017/6/23.
 */
@Data
public class Service {
    private String serviceName;
    private String url;
    private Integer port;
    private String packagePath;
    private String className;
    private String method;
    private String tag;
}
