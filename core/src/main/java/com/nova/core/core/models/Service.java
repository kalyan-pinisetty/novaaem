package com.nova.core.core.models;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Service {
	
	
	@Inject
	private List<ServiceItems> services;
	
	public List<ServiceItems> getServices() {

	        return new ArrayList<>(services);

	 

	    }
}
