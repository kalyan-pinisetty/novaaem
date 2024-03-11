package com.nova.core.core.models;

import java.util.HashMap;
import java.util.Map;

import org.apache.sling.api.resource.Resource;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = SlingHttpServletRequest.class)
public class CreatePageModel {

    private static final Logger logger = LoggerFactory.getLogger(CreatePageModel.class);

    @Inject
    private ResourceResolver resourceresolver;

    // Inside CreatePageModel

    public void createPage(String name, String title) {

        Map<String, Object> props = new HashMap<>();
        props.put("jcr:title", title);

       Resource pageRoot = resourceresolver.getResource("/content/nova/us");

        try {
            resourceresolver.create(pageRoot, name, props);
        } catch (PersistenceException ex) {
            ex.printStackTrace();
        }

    }

}
