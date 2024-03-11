package com.nova.core.core.services;

import com.day.cq.wcm.api.Page;
import java.util.*;

import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;

import org.apache.sling.api.resource.LoginException;

public interface DemoService {
    public Iterator<Page> getPages();

    public Iterator<Page> getPagePaths();

    public String getProperties() throws RepositoryException, LoginException;
}
