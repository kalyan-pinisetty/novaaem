package com.nova.core.core.servlets;

import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.model.WorkflowModel;
import com.nova.core.core.utils.ResolverUtil;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import com.nova.core.core.utils.ResolverUtil;

@Component(service = Servlet.class)
@SlingServletPaths(value = { "/bin/executeworkflow", "/nova/executeworkflow" })
public class NovaWorkflow extends SlingSafeMethodsServlet {
    private static final Logger LOG = LoggerFactory.getLogger(NovaWorkflow.class);
    // @Reference
    // private ResourceResolverFactory resourceResolverFactory;

    @Override
    protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp)
            throws ServletException, IOException {
        String status = "Workflow Executing";

         final ResourceResolver resourceResolver = req.getResourceResolver();

        String payload = req.getRequestParameter("page").getString();
        try {
            if (StringUtils.isNotBlank(payload)) {
                LOG.info("inside try");
               // ResourceResolver resourceResolver = ResolverUtil.newResolver(resourceResolverFactory);
                LOG.info("inside resResol");
                WorkflowSession workflowSession = resourceResolver.adaptTo(WorkflowSession.class);
                LOG.info("inside workflowSession");
                WorkflowModel workflowModel = workflowSession.getModel("/var/workflow/models/nova-page-version");
                LOG.info("inside workflowmodel");
                WorkflowData workflowData = workflowSession.newWorkflowData("JCR_PATH", payload);
                LOG.info("inside workflowData");
                status = workflowSession.startWorkflow(workflowModel, workflowData).getState();
            }

        } catch (Exception e) {
            LOG.info("\n ERROR IN WORKFLOW {} ", e.getMessage());
        }
        resp.setContentType("application/json");
        resp.getWriter().write(status);
    }

}