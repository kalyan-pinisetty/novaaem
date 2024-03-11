package com.nova.core.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;

import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class CtsUser {

    @Inject
    private String value;

    /* @Default(values ="kalyan") */
    /* @RequestAttribute(name = "value") */ /*
                                             * replacing the name jcr value to anything we want in dynamic in htl code
                                             */
    
    public String getValue() {
        return value;
    }

    public String getFamily() {
        return "insidectsuser";
    }

    @Inject
    @Named("sling:resourceType") /* calling the jcr properties using @named */
    private String email;

    public String getEmail() {
        return email;
    }

    @Inject
    private String dob;

    public String getDob() {
        return "Date " + dob.substring(0, 10) + " time " + dob.substring(11, 16);
    }

    @RequestAttribute(name = "color")
    @Optional
    private String color;

    public String getStringColor() {
        return color;
    }
    private String generateid;

    @PostConstruct
    protected void init() {
        generateid = value.substring(0, 3) + dob.substring(7, 10);
    }

    public String getGenerateid() {
        return generateid;
    }

}
