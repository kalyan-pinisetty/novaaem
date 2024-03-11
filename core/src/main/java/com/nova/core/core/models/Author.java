package com.nova.core.core.models;

import java.util.Iterator;
import java.util.List;

import javax.jcr.RepositoryException;

import org.apache.sling.api.resource.LoginException;

import com.day.cq.wcm.api.Page;
import com.nova.core.core.services.OSGiFactoryConfig;

public interface Author {
    String getFname();

    String getLname();

    boolean getIsProfessor();

    String getPageTitle();

    String getReqattribute();

    String getHomePageName();

    String getLastModifiedBy();

    Iterator<Page> getPagesList();
    public String getProperties() throws RepositoryException, LoginException;

    List<String> getPageTitleList();

    // Using Ranking/filter in OSGI for the below method

    String getServiceName();

    String getServiceNameB();

    public int getServiceId();

    public String getServiceNameModule();

    public String getServiceURL();

    //getting multiple config factory 

    public List<OSGiFactoryConfig> getAllOSGiConfigs();

    public String getPagePath();

     Iterator<Page> getPagesListRam();


     //kalyan from india
}
