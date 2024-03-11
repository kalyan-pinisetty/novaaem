package com.nova.core.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.nova.core.core.services.DummyEmailService;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

@Component(service = Servlet.class, immediate = true, property = {
        "sling.servlet.paths=/bin/formhandler",
        "sling.servlet.methods=POST"
})
public class SubmitFormServlet extends SlingAllMethodsServlet {

    @Reference
    private DummyEmailService dummyEmailService; // Inject your dummy email service

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form parameters

        String name = request.getParameter("name");

        String email = request.getParameter("email");

        // Call your dummy email service

        dummyEmailService.sendDummyEmail(name, email);

        // Set a response attribute for confirmation

        request.setAttribute("confirmationMessage", "Email sent successfully");

        // Forward back to the page or handle as needed

        // For simplicity, let's use a response writer
        // response.setContentType("text/html");
        // PrintWriter out = response.getWriter();
        // out.println("Email sent successfully");

        // request.getRequestDispatcher("response.jsp").forward(request, response);
        
        response.getWriter().write("Email sent successfully");

    }

}
