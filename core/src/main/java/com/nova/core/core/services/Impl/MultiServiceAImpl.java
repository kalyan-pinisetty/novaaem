package com.nova.core.core.services.Impl;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nova.core.core.services.MultiService;

@Component(service = MultiService.class, immediate=true, name = "serviceA")
public class MultiServiceAImpl implements MultiService {

    private static final Logger LOG = LoggerFactory.getLogger(MultiServiceAImpl.class);

    @Override
    public String getName() {

        LOG.info("Inside getName");
        return "OSGI Service from MultiServiceA";
    }

}
