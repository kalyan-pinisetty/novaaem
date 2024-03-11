package com.nova.core.core.models.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jcr.RepositoryException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.ResourcePath;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.search.QueryBuilder;
import com.day.cq.wcm.api.Page;//page api
import com.nova.core.core.models.Author;
import com.nova.core.core.services.DemoService;
import com.nova.core.core.services.DemoServiceB;
import com.nova.core.core.services.DeveloperInfo;
import com.nova.core.core.services.MultiService;
import com.nova.core.core.services.OSGiConfigModule;
import com.nova.core.core.services.OSGiFactoryConfig;

@Model(adaptables = SlingHttpServletRequest.class, adapters = Author.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AuthorImpl implements Author {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorImpl.class);

    // using osgi service

    // calling OSGI Service
    @OSGiService
    DemoService demoService;

    @Override
    public Iterator<Page> getPagesList() {
        return demoService.getPages();
    }

    @Override
    public String getProperties() throws RepositoryException, LoginException {
        return demoService.getProperties();
    }

    // calling other OSGI service
    @Inject
    
    DemoServiceB demoServiceB;

    @Override
    public List<String> getPageTitleList() {
        return demoServiceB.getPages();
    }

    // using OSGI ranking /filtering
    // calling OSGI service

    // if particular service needs to be caalled sometimes but serviceranking will
    // effect that so that we can
    // overcome this by adding filter to the calling OSGI service here
    @OSGiService // (filter = "(component.name = serviceA)")
    MultiService multiService;

    @Override
    public String getServiceName() {
        return multiService.getName();
    }

    @OSGiService // (filter = "(component.name = serviceB)")
    MultiService multiServiceB;

    @Override
    public String getServiceNameB() {
        return multiServiceB.getName();
    }

    // @Inject
    // // @Optional
    // @Via("resource")
    @ValueMapValue // will work for SlingHttpServletRequest as well if not resource
    @Default(values = "AEM")
    String fname;

    @Inject
    @Required
    @Via("resource")
    @Default(values = "GEEKS")
    String lname;

    @Inject
    @Default(values="/content/nova/us/en")
    private String pagePath;

    @Override
    public String getPagePath() {
        LOGGER.info("4kalyan page path found");
       return pagePath;
    }

      @Override
    public Iterator<Page> getPagesListRam() {
       return demoService.getPagePaths();
    }

    // @Inject
    // @Via("resource") //use either inject or valuemapvalue to get the dialog
    // values when using SlingHttpServletRequest
    @ValueMapValue
    boolean professor;

    // displaying page title using ScriptVariable

    @ScriptVariable
    Page currentPage; // we are trying to inject a page object inside a resource
                      // that we cannot do here in Resource.class because methods are not avaialble in
                      // res.class
                      // to get the same we are using SlingHttpServletRequest.class
                      // and make every @Inject to Inject @Via(resource). beacuse @inject will not
                      // work with SlingHttpRequest

    @Override
    public String getPageTitle() { // getter for pagetitle
        return currentPage.getTitle();

    }

    @SlingObject // suppose want to inject commonly used sling objects like
                 // ResourceResolver,Request,Response.
    ResourceResolver resourceresolver;

    @Self // to inject a object itself inside a model
    SlingHttpServletRequest slingHttpServletrequest;

    @RequestAttribute(name = "rattribute")
    // if need a value to pass dynamically from slightly to sling model we can use
    // requestAttribute
    private String reqattribute;

    public String getReqattribute() {
        return reqattribute;
    }

    @ResourcePath(path = "/content/nova/us/en/novapage")
    @Via("resource")
    Resource resource; // this resource will have @ResourcePath inside this and it will get all the
                       // methods available inside Resource

    @OSGiService
    QueryBuilder queryBuilder;

    @Inject
    @Named("jcr:lastModifiedBy") // get properties using @Named and as it is adapted to SlingHttpServletReq
                                 // inject via resource
    @Via("resource")
    String modifiedBy;

    @Override
    public String getLastModifiedBy() {
        return modifiedBy;
    }

    @Override
    public String getHomePageName() {
        return resource.getName();
    }

    @Override
    public String getFname() {
        return fname;

    }

    @Override
    public String getLname() {
        return lname;
    }

    @Override
    public boolean getIsProfessor() {
        return professor;
    }

    // osgi service using configguration class being called here tutorial no 29 till
    // 33
    @OSGiService
    OSGiConfigModule oSGiConfigModule;

    @Override
    public int getServiceId() {
        return oSGiConfigModule.getServiceId();

    }

    @Override
    public String getServiceNameModule() {
        return oSGiConfigModule.getServiceNameModule();

    }

    @Override
    public String getServiceURL() {
        return oSGiConfigModule.getServiceURL();

    }

    // osgi service using configguration factory to call multiple configurations
    // class being called here tutorial no 29 till 33

    @OSGiService
    OSGiFactoryConfig oSGiFactoryConfig;

    @Override
    public List<OSGiFactoryConfig> getAllOSGiConfigs() {
        return oSGiFactoryConfig.getAllConfigs();
    }

    // @OSGiService
    // DeveloperInfo developerInfo;

    // @Override
    // public String getInfo(){
    //     return developerInfo.getDeveloperInfo();
    // }

    @PostConstruct // if u want any method to be executed after all the injections has been
                   // completed
                   // then postconstrcut will happen
    protected void init() {// we can give any name to this but only one init method should be there

         LOGGER.info("4kalyan page path found"+pagePath);
         LOGGER.info("\n Inside INIT {} : {}", currentPage.getTitle(), resource.getPath());
    }

//   get the current page 

//write sling model for  firstname,lastname and isprofessor
/* @Model(adaptables = {Resource.class, SlingHttpServletRequest.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Professor {

    @Inject
    @Named("firstName")
    private String firstName;

    @Inject
    @Named("lastName")
    private String lastName;

    @Inject
    @Named("isProfessor")
    private boolean isProfessor;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isProfessor() {
        return isProfessor;
    }

} */


}
