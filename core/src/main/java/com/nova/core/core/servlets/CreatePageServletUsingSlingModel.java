package com.nova.core.core.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Reference;

import com.nova.core.core.models.CreatePageModel;

public class CreatePageServletUsingSlingModel extends SlingAllMethodsServlet {

    @Reference
    private CreatePageModel pageModel;

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) {

        String name = request.getParameter("name");
        String title = request.getParameter("title");

        pageModel.createPage(name, title);
        response.setStatus(HttpServletResponse.SC_CREATED);
        response.setContentType("text/plain");
        try {
            response.getWriter().write("Page Created");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}