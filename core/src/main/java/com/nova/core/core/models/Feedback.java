package com.nova.core.core.models;

import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

@Model(adaptables = Resource.class, resourceType = {"/apps/nova/components/aemcustom/feedback"}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", selector = "me", extensions = "json")

@JsonRootName("Feedback")
public class Feedback {

    @ChildResource(name = "items")
    Resource child;

    public Resource getName() {

        return child.getChild("fullname");

    }

    public Resource getEmail() {

        return child.getChild("email");
    }

    public Resource getFeedback() {

        return child.getChild("feedback");

    }
}
