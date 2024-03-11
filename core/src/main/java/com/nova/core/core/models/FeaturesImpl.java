package com.nova.core.core.models;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.LoggerFactory;

@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class FeaturesImpl {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(FeaturesImpl.class);

	@Inject
	private String icon;

    public String getIcon() {
        return icon;
    }
    @Inject
	private String iconcolor;
    
    public String getIconcolor(){
        return iconcolor;
    }
    

    @Inject
	private String icontitle;
    public String getIcontitle() {
        return icontitle;
    }


}