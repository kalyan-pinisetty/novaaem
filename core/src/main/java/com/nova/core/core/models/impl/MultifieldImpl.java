package com.nova.core.core.models.impl;

import java.util.*;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.nova.core.core.models.Multifield;

@Model(adaptables=SlingHttpServletRequest.class, adapters=Multifield.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultifieldImpl implements Multifield{

    @ValueMapValue
   private List<String> products;

    @Override
    public List<String> getProducts() {
        if(products!=null){
        return new ArrayList<String>(products);
        }else{
            return Collections.emptyList(); 
        }
 }
    
}
