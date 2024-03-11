package com.nova.core.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CustomImpl {

    @Inject

    private String company;

    public String getCompany() {

        return company;

    }

    @Inject

    private String exp;

    public String getExp() {

        return exp;

    }

}
