package com.nova.core.core.servlets;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * ModifyComponent
 */

@Component(service = ModifyComponent.class)
public class ModifyComponent {

    @Reference
    private ResourceResolverFactory resolverFactory;

    public void modifyNovaFeatures() throws LoginException {

        ResourceResolver resolver = resolverFactory.getServiceResourceResolver(null);

        try {

            String pagePath = "/content/nova/us/en/demo";
            String compName = "Nova Features";

            Resource pageRes = resolver.getResource(pagePath);
            Resource compRes = pageRes.getChild(compName);

            if (compRes != null) {

                ValueMap vm = compRes.adaptTo(ValueMap.class);

                // Modify text property
                vm.put("text", "New feature text");

                // Modify link URL
                vm.put("linkURL", "/products");

                resolver.commit();

            }

        } catch (PersistenceException ex) {
            // error handling
        } finally {
            resolver.close();
        }

    }

}