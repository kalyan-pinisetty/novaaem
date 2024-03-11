package com.nova.core.core.services.Impl;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.nova.core.core.models.Author;
import com.nova.core.core.services.DemoService;
import com.nova.core.core.utils.ResolverUtil;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Iterator;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;

@Component(service = DemoService.class, immediate = true)
public class DemoServiceImpl implements DemoService {
    private static final Logger LOG = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Reference
    private SlingRepository slingRepository;

    @Activate
    public void activate(ComponentContext componentContext) {
        LOG.info("\n ==============INSIDE ACTIVATE================");
        LOG.info("\n {} = {} ", componentContext.getBundleContext().getBundle().getBundleId(),
                componentContext.getBundleContext().getBundle().getSymbolicName());
    }

    @Deactivate
    public void deactivate(ComponentContext componentContext) {
        LOG.info("\n ==============INSIDE DEACTIVATE================");
    }

    @Modified
    public void modified(ComponentContext componentContext) {
        LOG.info("\n ==============INSIDE MODIFIED================");
    }

    @Override
    public Iterator<Page> getPages() {
        try {
            LOG.info("inside try");
            ResourceResolver resourceResolver = ResolverUtil.newResolver(resourceResolverFactory);
            LOG.info("inside resourceResolver");
            PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
            LOG.info("inside PageManager");
            Page page = pageManager.getPage("/content/nova/us/en");
            LOG.info("inside page");
            Iterator<Page> pages = page.listChildren();
            LOG.info("inside iterator");
            return pages;
        } catch (LoginException e) {
            LOG.info("\n Login Exception {} ", e.getMessage());
        }
        return null;
    }

    @Override
    public String getProperties() throws RepositoryException, LoginException {

        try {

            ResourceResolver resourceResolver = ResolverUtil.newResolver(resourceResolverFactory);
            LOG.info("inside resourceResolver");
            Node imageNode = resourceResolver.getResource("/content/nova/us/en/demo/jcr:content/image")
                    .adaptTo(Node.class);
            LOG.info("inside node");
            if (imageNode != null && imageNode.hasProperty("fileReference")) {
                LOG.info("inside if condition");
                return imageNode.getProperty("fileReference").getString();
            }
        } catch (LoginException e) {
            LOG.info("\n Login Exception {} ", e.getMessage());
        }

        return null;

    }

    @Reference
    Author author;

    public String path= author.getPagePath();

     @Override
    public Iterator<Page> getPagePaths() {
        try {
            LOG.info("inside try");
            ResourceResolver resourceResolver = ResolverUtil.newResolver(resourceResolverFactory);
            LOG.info("inside resourceResolver");
            PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
            LOG.info("inside PageManager");
            Page page = pageManager.getPage(path);
            LOG.info("inside page");
            Iterator<Page> pages = page.listChildren();
            LOG.info("inside iterator");
            return pages;
        } catch (LoginException e) {
            LOG.info("\n Login Exception {} ", e.getMessage());
        }
        return null;
    }

}
