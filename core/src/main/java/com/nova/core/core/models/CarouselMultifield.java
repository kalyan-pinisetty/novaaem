
package com.nova.core.core.models;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import java.util.*;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

import com.adobe.cq.dam.cfm.ContentElement;
import com.adobe.cq.dam.cfm.ContentFragment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CarouselMultifield
{
 public static final String MODEL_TITLE = "AEM Carosel Component";
 public static final String CF_PATH = "/content/dam/nova/imagesforcarousel/carouselmultifield";

 private static final Logger LOG = LoggerFactory.getLogger(CarouselMultifield.class);

 private List<String> imagePaths=new ArrayList<String>();


 @Inject
 @Self
 private Resource resource;

 @Inject
 ResourceResolver resourceResolver;
/*  private Optional<ContentFragment> contentFragment; */



 @PostConstruct
 public void init() {
  Resource fragmentResource = resourceResolver.getResource(CF_PATH);
 /*  contentFragment = Optional.ofNullable(fragmentResource.adaptTo(ContentFragment.class)); */
  ContentFragment cf = resourceResolver.resolve(CF_PATH).adaptTo(ContentFragment.class);
  String[] array = cf.getElement("imagemultifield").getValue().getValue(String[].class);
  int x=0;
  while(x!=array.length){
     imagePaths.add(array[x]);
     x+=1;
  }
  LOG.info(imagePaths.toString());
}




 public List<String> getCardImageList() 
 {
   LOG.info(imagePaths.toString());
   return imagePaths;
  

   }


}