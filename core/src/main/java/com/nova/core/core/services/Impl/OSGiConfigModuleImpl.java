package com.nova.core.core.services.Impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

import com.nova.core.core.config.NovaOSGiConfig;
import com.nova.core.core.services.OSGiConfigModule;

@Component(service = OSGiConfigModule.class, immediate = true)
@Designate(ocd = NovaOSGiConfig.class)
public class OSGiConfigModuleImpl implements OSGiConfigModule {

    private int serviceId;
    private String serviceName;
    private String serviceURL;

    @Activate
    protected void activate(NovaOSGiConfig novaOSGiConfig) {
        serviceId = novaOSGiConfig.serviceID();
        serviceName = novaOSGiConfig.serviceName();
        serviceURL = novaOSGiConfig.serviceURL();
    }

    @Override
    public int getServiceId() {
        return serviceId;

    }

    @Override
    public String getServiceNameModule() {
        return serviceName;
    }

    @Override
    public String getServiceURL() {
        return serviceURL;

    }

}
