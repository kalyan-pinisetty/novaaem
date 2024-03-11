package com.nova.core.core.models;

import java.util.List;
import java.util.*;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.LoggerFactory;

@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Novahero {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Novaheroimpl.class);

    @Inject
	private List<Novaheroimpl> details;


    public List<Novaheroimpl> getDetails() {

		return new ArrayList<>(details);

	}

	@Inject
	private String fileReference;

	public String getFileReference() {
		return fileReference;
	}
}
