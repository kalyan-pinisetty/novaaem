package com.nova.core.core.models;

import com.nova.core.core.models.CourseOSGI;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;


@Component(service = CourseOSGI.class, immediate = true)
@Designate(ocd = CourseOSGIImpl.Config.class)
public class CourseOSGIImpl implements CourseOSGI {

    private static final Logger LOG = LoggerFactory.getLogger(CourseOSGIImpl.class);

  
    private String contentfragmentpath;

    
    @Activate
    public void activate(Config config) {
        LOG.debug("enter activate()");

        this.contentfragmentpath = config.contentfragmentpath();
        LOG.debug("enter contentfragmentpath", config.contentfragmentpath());

    }

    @Override
    public String getContentFragmentPath() {
        return contentfragmentpath;
    }

    public void setContentFragmentPath(String contentfragmentpath) {
        this.contentfragmentpath = contentfragmentpath;
    }

    @ObjectClassDefinition( 
    		name="Card Component - OSGI Configuration",
            description = "Content Fragment OSGI Service"
    )
    public @interface Config {
        @AttributeDefinition(
                name = "Content Fragment Path",
                description = "Configuration to set the CF Path",
                type = AttributeType.STRING
             
        )
        String contentfragmentpath() default "/content/dam/nova/cardscf";

        
}
}
