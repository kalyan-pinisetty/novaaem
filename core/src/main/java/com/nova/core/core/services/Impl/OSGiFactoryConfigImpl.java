package com.nova.core.core.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nova.core.core.config.NovaOSGiFactoryConfig;
import com.nova.core.core.services.OSGiFactoryConfig;

@Component(service = OSGiFactoryConfig.class,configurationPolicy = ConfigurationPolicy.REQUIRE)
@Designate(ocd = NovaOSGiFactoryConfig.class, factory = true)
public class OSGiFactoryConfigImpl implements OSGiFactoryConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(OSGiFactoryConfigImpl.class);

    private int configID;
    private String serviceName;
    private String serviceURL;
    private List<OSGiFactoryConfig> configsList;

    @Activate
    @Modified
    protected void activate(final NovaOSGiFactoryConfig config) {
        configID = config.configID();
        serviceName=config.serviceName();
        serviceURL=config.serviceURL();
    }

    //everytime when we .create a new config in backend that will get refreshed once created
    // so everytime it will give the last saved configuration as output so to overcome that
    //we have creatd two methods namely bind and unbind that implements OSGiFactoryConfig with input 
    //parameter as same if list is null add config to the list and ther after remove it
     @Reference(service = OSGiFactoryConfig.class, cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
    public void bindOSGiFactoryConfig(final OSGiFactoryConfig config) {
        if (configsList == null){
            configsList = new ArrayList<>();
        }
        configsList.add(config);

    }

    public void unbindOSGiFactoryConfig(final OSGiFactoryConfig config) {
        configsList.remove(config);
    }


    @Override
    public int getConfigID() {
        return configID;

    }

    @Override
    public String getServiceName() {
        return serviceName;

    }

    @Override
    public String getServiceURL() {
        return serviceURL;

    }
    @Override
    public OSGiFactoryConfig get(int configID) {
        for (OSGiFactoryConfig confFact : configsList) {
            if (configID==confFact.getConfigID())
                return confFact;
        }
        return null;
    }

    @Override
    public List<OSGiFactoryConfig> getAllConfigs(){
        return configsList;
    }

}
