package com.nova.core.core.models;

import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.Source;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.ResourcePath;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
/* @Model
@Inject
@Default
@Named
@Optional
@PostConstruct
@ResourcePath
@Source
@Via
@OSGiService
@ScriptVariable
@AemObject
ModelFactory
SlingModel Exporter
 */
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Ctsu {

    // assigning the log values

    private static final Logger LOG = LoggerFactory.getLogger(Ctsu.class);
    /*
     * @ValueMapValue
     * 
     * private String textValue;
     * 
     * @Inject
     * 
     * @Required
     * 
     * @Default(values = "AEM")
     * 
     * @Via("resource")
     * 
     * private String name;
     * 
     * 
     * @OSGiService
     * 
     * private DemoOSgi demoOSGI;
     * 
     * 
     * public String getTextValue() {
     * 
     * if (textValue != null) {
     * 
     * return textValue;
     * 
     * } else {
     * 
     * return "Enter the text value";
     * 
     * }
     * 
     * }
     * 
     * public String getNameValue() {
     * 
     * return name;
     * 
     * }
     * 
     * 
     * public String getOSGIDemo()
     * 
     * {
     * 
     * return demoOSGI.getTextCapital(name);
     * 
     * }
     * 
     * 
     * @Inject
     * 
     * @Named("jcr:title")
     * 
     * @Via("resource")
     * 
     * private String title;
     * 
     * public String getTitle() {
     * 
     * return title;
     * 
     * }
     * 
     * @ScriptVariable(name = "currentPage")
     * 
     * Page page;
     * 
     * @Inject
     * 
     * @Source("script-bindings")
     * 
     * private Page currentPage;
     * 
     * public String getTitlePage() {
     * 
     * return page.getTitle();
     * 
     * }
     */
    @ScriptVariable(name = "currentPage")
    Page page;
    @Inject
    @Source("script-bindings")
    private Page currentPage;
    public String getTitlePage() {
        return page.getTitle();
    }

    @Inject
    @Via("resource")
    private String dob;

    public String getStringDob() {
        return "Date " + dob.substring(0, 10) + " time " + dob.substring(11, 16);
    }

    @RequestAttribute(name = "value")

    private String value;

    public String getStringName() {

        return value;

    }

    /* calling a sling model inside other sling model */
    @Inject
    @Self
    @Via("resource")
    private CtsUser ctsuser;

    public String getStringEmail() {
        return ctsuser.getFamily();
    }

    /*
     * @ResourcePath(path = "/content/aem-practice/language-masters/en")
     * 
     * @Via("resource")
     * 
     * Resource resourcePage;
     * 
     * public String getHomePageName() {
     * 
     * return resourcePage.getName();
     * 
     * }
     * 
     * @SlingObject
     * 
     * private ResourceResolver resolver;
     * 
     * public String getHomePage()
     * 
     * {
     * 
     * Resource resource =
     * resolver.getResource("/content/aem-practice/language-masters/en/ctsuser");
     * 
     * return resource.getParent().getPath();
     * 
     * }
     * 
     * public String getPagePath()
     * 
     * {
     * 
     * return currentPage.getPath();
     * 
     * }
     * 
     * @Self
     * 
     * @Via("resource")
     * 
     * private Node node;
     * 
     * public String getNodeName() throws RepositoryException
     * {
     * Node node = resolver.adaptTo(Node.class);
     * return node.getName();
     * }
     */
}
