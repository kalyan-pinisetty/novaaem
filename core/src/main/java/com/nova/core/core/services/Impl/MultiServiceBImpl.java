package com.nova.core.core.services.Impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceRanking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nova.core.core.services.MultiService;

@Component(service = MultiService.class, immediate=true, name = "serviceB")
//@ServiceRanking(1001)  // service ranking used to give for classes so that this class or method will get the preference if it has same method in interface
public class MultiServiceBImpl implements MultiService {

    private static final Logger LOG = LoggerFactory.getLogger(MultiServiceBImpl.class);

    @Override
    public String getName() {

        LOG.info("inside getName method");
        return "OSGI Service from MultiServiceBImpl";
    }

}
