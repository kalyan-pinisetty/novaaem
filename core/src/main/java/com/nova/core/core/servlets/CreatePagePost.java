package com.nova.core.core.servlets;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
@Component(service = Servlet.class, immediate = true)
@SlingServletPaths
(
    value = "/kalyan/createpagepost"
)
// property = {
//         "sling.servlet.paths=/kalyan/createpagepost",
//         "sling.servlet.methods=POST"


public class CreatePagePost extends SlingAllMethodsServlet {
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @Override
    protected void doPost(final SlingHttpServletRequest request, final SlingHttpServletResponse response)
            throws ServletException, IOException {
        PageManager pageManager = request.getResourceResolver().adaptTo(PageManager.class);
        try {
            String pageName = request.getParameter("pageName");
            String title = request.getParameter("title");
            for (int i = 0; i < 3; i++) {
                pageManager.create("/content/nova/us/en", pageName + i, 
                        "/conf/nova/settings/wcm/templates/page-content", title + i, true);
            }
        } // Add this 
        catch (WCMException e) {
          logger.error("Exception " + e.getMessage());
          response.getWriter().write("Error creating page: " + e.getMessage());
          return;
        }
        response.getWriter().write("Your Page is created Successfully.");
    }
}