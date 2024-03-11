package com.nova.core.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;

import com.adobe.cq.export.json.ComponentExporter;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.jcr.Node;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component(service = Servlet.class, property = {
        "sling.servlet.methods=POST",
        "sling.servlet.paths=/bin/feedback"
})

public class Feedback extends SlingAllMethodsServlet  {

  
    @Override
    protected void doPost(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("fname");
        String email = req.getParameter("femail");
        String feedback = req.getParameter("ffeedback");

        try {
            ResourceResolver resolver = req.getResourceResolver();
            Resource resource = resolver
                    .getResource("/content/nova/us/en/feedback/jcr:content/root/container/container");
            Node node = resource.adaptTo(Node.class);
            Node nameNode = node.addNode(name);
            Resource noderesource = resolver.getResource(nameNode.getPath());

            ModifiableValueMap map = noderesource.adaptTo(ModifiableValueMap.class);
            map.put("fullname", name);
            map.put("email", email);
            map.put("feedback", feedback);

            resolver.commit();
            resp.setContentType("text/plain");
            resp.getWriter().write("Feedback received and stored in the repository.");
            resp.getWriter().flush();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
