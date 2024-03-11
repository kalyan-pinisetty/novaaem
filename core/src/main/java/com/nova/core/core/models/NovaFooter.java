package com.nova.core.core.models;

import java.util.List;
import java.util.ArrayList;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.LoggerFactory;

@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class NovaFooter {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(NovaFooterImpl.class);

	@Inject
	private String heading;

	
	public String getHeading() {
		return heading;
	}
	
	@Inject
	private String headinglink;

	
	public String getHeadinglink() {
		return headinglink;
	}
	
	@Inject
	private String subtext;

	public String getSubtext() {
		return subtext;
	}

	@Inject
	private List<NovaFooterImpl> iconcards;

	public List<NovaFooterImpl> getIconcards() {
		return new ArrayList<>(iconcards);
	}
	
	@Inject
	private List<NovaFooterImpl> useful;

	public List<NovaFooterImpl> getUseful() {
		return new ArrayList<>(useful);
	}
	
	@Inject
	private List<NovaFooterImpl> services;

	public List<NovaFooterImpl> getServices() {
		return new ArrayList<>(services);
	}

	@Inject
	private String address;
	
	public String getAddress() {
		return address;
	}
	
	@Inject
	private String phonenumber;
	

	public String getPhonenumber() {
		return phonenumber;
	}
	

	@Inject
	private String email;


	public String getEmail() {
		return email;
	}


}
