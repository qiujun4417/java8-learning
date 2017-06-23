package com.nick.soa.service.consul;

import com.google.common.net.HostAndPort;
import com.nick.soa.service.register.AbstractServiceRegister;
import com.nick.soa.service.register.Service;
import com.orbitz.consul.AgentClient;
import com.orbitz.consul.Consul;
import com.orbitz.consul.model.agent.ImmutableRegistration;

/**
 * Created by nick on 2017/6/23.
 */
public class ConsulServiceRegister extends AbstractServiceRegister{

    private AgentClient agentClient;

    public ConsulServiceRegister(Integer consulPort, String consulUrl){
        this.agentClient = Consul.builder().withHostAndPort(HostAndPort.
                fromHost(consulUrl + ":" + consulPort))
                .build().agentClient();
    }

    @Override
    public void registerService(Service service) {
        String serviceId = buildServiceId(service);
        ImmutableRegistration.Builder builder = ImmutableRegistration.builder();
        builder.id(serviceId).name(service.getServiceName()).
                address(service.getUrl()).
                port(service.getPort()).
                addTags(service.getTag());
        agentClient.register(builder.build());
        shutDownCallBack(serviceId);
    }

    @Override
    protected void shutDownCallBack(String serviceId) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> agentClient.deregister(serviceId)));
    }
}
