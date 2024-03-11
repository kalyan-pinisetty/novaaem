package com.nova.core.core.models;

import java.util.List;
import java.util.*;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.LoggerFactory;

@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Features {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Features.class);
    
    @Inject
	private String title;
    public String getTitle() {return title;}
    @Inject
	private String maintitle;
    public String getMaintitle() {return maintitle;}
	@Inject
	private String description;
    public String getDescription() {return description;}
    @Inject
	private String linktext;
	public String getLinktext() {return linktext;}
    @Inject
	private String links;
    public String getLinks() {return links;}
    @Inject
	private List<FeaturesImpl> iconcards;
    public List<FeaturesImpl> getIconcards() {return new ArrayList<>(iconcards);}
    @Inject
	private String fileReference;
    public String getFileReference() {return fileReference;}
}
