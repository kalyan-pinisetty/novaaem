package com.nova.core.core.models;

import java.util.List;
import java.util.*;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.LoggerFactory;

@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class SaiPavan {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TextDes.class);

	@Inject
	private String name;

	@Inject
	private String cost;

	public String getName() {
		return name;
	}

	public String getCost() {
		return cost;
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
