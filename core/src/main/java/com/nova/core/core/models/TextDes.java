package com.nova.core.core.models;

import java.util.List;
import java.util.*;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.LoggerFactory;

@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class TextDes {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TextDes.class);

	@Inject
	private String title;

	@Inject
	private String description;

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}


	@Inject
	private String linktext;

	

	public String getLinktext() {
		return linktext;
	}

	@Inject
	private String links;

	public String getLinks() {
		return links;
	}
	@Inject
	private String fileReference;

	public String getFileReference() {
		return fileReference;
	}
}
