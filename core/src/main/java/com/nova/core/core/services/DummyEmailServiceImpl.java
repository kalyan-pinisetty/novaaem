package com.nova.core.core.services;


import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

    @Component(service = DummyEmailService.class)
    public class DummyEmailServiceImpl implements DummyEmailService {

        private final Logger logger = LoggerFactory.getLogger(DummyEmailServiceImpl.class);
    @Override
    public void sendDummyEmail(String name, String email) {
        // Simulate sending an email

       logger.info("Simulating email to {} at {}", name, email);

    }

}
