package com.nova.core.core.models;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;


@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NovaHeaderImpl {

	@Inject
	private List<NovaHeader> linkheader;

	public List<NovaHeader> getLinkheader() {

		return new ArrayList<>(linkheader);

	}

	@Inject
	private String pageheading;

	public String getPageheading() {
		return pageheading;
	}

	@Inject
	private String pageheadinglink;

	public String getPageheadinglink() {
		return pageheadinglink;
	}

}
