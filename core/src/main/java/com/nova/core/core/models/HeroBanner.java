package com.nova.core.core.models;
import java.util.List;
import java.util.*;
import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.LoggerFactory;
@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HeroBanner {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(HeroBanner.class);

    @Inject
    private String title;
    @Inject
    private String subtitle;
    @Inject
    private String image;
    @Inject
    private  String ctatext;
    @Inject
    private  String ctalink;
    public String getTitle() {
        return title;
    }
    
    public String getSubtitle() {
        return subtitle;
    }
   
    public String getImage() {
        return image;
    }
    
    public String getCtatext() {
        return ctatext;
    }
    
    public String getCtalink() {
        return ctalink;
    }
    @Inject

    private String fileReference;
    public String getFileReference() {

        return fileReference;

    }

    

}
