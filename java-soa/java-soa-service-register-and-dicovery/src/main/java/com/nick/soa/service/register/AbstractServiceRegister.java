package com.nick.soa.service.register;



/**
 * Created by nick on 2017/6/23.
 */
public abstract class AbstractServiceRegister implements ServiceRegister {

    private static final String COLON = ":";
    private static final String SLASH = "/";

    protected String buildServiceId(Service service){
        StringBuffer sb = new StringBuffer();
        sb.append(service.getUrl()).append(COLON).
                append(service.getPort()).
                append(SLASH).
                append(service.getPackagePath()).append(SLASH).
                append(service.getClassName()).append(SLASH).
                append(service.getMethod()).append(SLASH).
                append(service.getTag());
        return sb.toString();
    }

    abstract protected void shutDownCallBack(String serviceId);
}
