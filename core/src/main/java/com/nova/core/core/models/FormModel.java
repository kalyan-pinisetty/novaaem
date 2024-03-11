package com.nova.core.core.models;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.api.resource.Resource;

@Model(adaptables = SlingHttpServletRequest.class)
public class FormModel {

  @Inject
  private Resource component;

  public String getAction() {
    return component.getResourceResolver().map("/bin/formhandler"); 
  }

  public String getName() {
    return component.getValueMap().get("name", "");
  }

  public String getEmail() {
    return component.getValueMap().get("email", ""); 
  }

}