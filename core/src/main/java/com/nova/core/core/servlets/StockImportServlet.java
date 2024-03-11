package com.nova.core.core.servlets;

import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;

import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.json.JSONObject;
import java.io.IOException;
import javax.servlet.ServletException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = {javax.servlet.Servlet.class})
@SlingServletPaths(value = "/bin/importStockData")
public class StockImportServlet extends SlingAllMethodsServlet {

    @Reference
    private ResourceResolverFactory resolverFactory;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("application/json");
        String apiEndpoint = "https://www.alphavantage.co/query"; // Replace with actual stock data API endpoint
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(apiEndpoint);
            String jsonData = EntityUtils.toString(httpClient.execute(httpGet).getEntity());

            // Parse the JSON Data
            JSONObject stockData = new JSONObject(jsonData);
            updateFooterWithStockData(stockData);

            response.getWriter().write("Stock data imported successfully");
        } catch (Exception e) {
            response.setStatus(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Error importing stock data: " + e.getMessage());
        }
    }
    
    private void updateFooterWithStockData(JSONObject stockData) {
        ResourceResolver resourceResolver = null;
        try {
            resourceResolver = resolverFactory.getServiceResourceResolver(null);
            Resource footerResource = resourceResolver.getResource("/content/nova/us/en/jcr:content"); // Update the path to your footer component
            if (footerResource != null) {
                ModifiableValueMap footerProps = footerResource.adaptTo(ModifiableValueMap.class);
                if (footerProps != null) {
                    // Assuming there is a property in the footer component to hold stock data
                    footerProps.put("stockData", stockData.toString());
                    resourceResolver.commit();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resourceResolver != null && resourceResolver.isLive()) {
                resourceResolver.close();
            }
        }
    }
}
