package com.nova.core.core.models;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.dam.cfm.ContentFragment;
import com.nova.core.core.models.CourseOSGI;


@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class CourseModel {
	public static final String MODEL_TITLE = "cardsmodel";
	//public static final String cfpath = "/content/dam/nova/cardscf";
	private static final Logger LOGGER = LoggerFactory.getLogger(CourseModel.class);
	
	@OSGiService
	CourseOSGI courseosgi;
	
	@Inject
	ResourceResolver resourceResolver;
	
	private Optional<ContentFragment> contentFragment;



	public List<CourseCfModel> getContentfragmentvalues() throws ParseException {
		
       List<CourseCfModel> contentfragmentvalues = new ArrayList<>();
       
       String cfpath = courseosgi.getContentFragmentPath();
		
		Resource courses = resourceResolver.getResource(cfpath);
	
			for (Resource items : courses.getChildren()) {
				 LOGGER.debug("Path {}",items);
				contentFragment = Optional.ofNullable(items.adaptTo(ContentFragment.class));
				LOGGER.debug("Content Fragment {}",contentFragment);
				contentfragmentvalues.add(new CourseCfModelImpl(contentFragment));
			
			}
			LOGGER.debug("Content Fragment {}",contentfragmentvalues);

		return contentfragmentvalues;
		
	}

}

