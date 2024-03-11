package com.nova.core.core.models;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.LoggerFactory;

@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Novaheroimpl {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Novaheroimpl.class);

	@Inject
	private String title;

    public String getTitle() {
		return title;
	}

    @Inject
    private String subtitle;

	public String getSubtitle() {
        return subtitle;
    }

    @Inject
	private String description;

	public String getDescription() {
		return description;
	}

}
