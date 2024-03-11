package com.nova.core.core.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.request.RequestParameter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.commons.jcr.JcrConstants;
import org.apache.sling.api.servlets.HttpConstants;

@Component(service = Servlet.class, immediate =true )
@SlingServletResourceTypes
(
    methods = {HttpConstants.METHOD_GET,HttpConstants.METHOD_POST},
    resourceTypes =  "nova/components/page",
    selectors = {"nova","test"},
    extensions = {"txt","xml"}
    
)
public class ResourceTypeServlet extends SlingAllMethodsServlet  {

    private static final Logger LOG = LoggerFactory.getLogger(ResourceTypeServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request,SlingHttpServletResponse response) throws ServletException, IOException{
        final Resource resource  =  request.getResource();
        response.setContentType("text/plain");
        response.getWriter().write("Page Title = " + resource.getValueMap().get(JcrConstants.JCR_TITLE));
    }

    @Override
    protected void doPost(SlingHttpServletRequest req,SlingHttpServletResponse resp) throws ServletException, IOException{
        try {
            LOG.info("\n ------------------------STARTED POST-------------------------");
            List<RequestParameter> requestParameterList=req.getRequestParameterList();
            for(RequestParameter requestParameter : requestParameterList){
                LOG.info("\n ==PARAMETERS===>  {} : {} ",requestParameter.getName(),requestParameter.getString());
            }
        }catch (Exception e){
            LOG.info("\n ERROR IN REQUEST {} ",e.getMessage());
        }
        resp.getWriter().write("======FORM SUBMITTED========");
    }
    
}
