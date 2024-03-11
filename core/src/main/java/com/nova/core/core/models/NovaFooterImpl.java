package com.nova.core.core.models;

import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NovaFooterImpl {
	
	@Inject
	private String linktext;

	public String getLinktext() {
		return linktext;
	}

	@Inject
	private String link;

	public String getLink() {
		return link;
	}

	@Inject
	private String icon;
	
	public String getIcon() {
		return icon;
	}

	@Inject
	private String iconlink;
	
	public String getIconlink() {
		return iconlink;
	}

}
