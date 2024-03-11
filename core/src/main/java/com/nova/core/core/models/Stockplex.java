package com.nova.core.core.models;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;

import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.osgi.service.component.annotations.Reference;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;

import com.adobe.cq.export.json.ComponentExporter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.nova.core.core.services.MultiService;
@Model(adaptables=SlingHttpServletRequest.class,		
		adapters= {ComponentExporter.class},
        resourceType = "nova/components/content/stockplex",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name="jackson", extensions = "json",selector = "nova",
options = {
    @ExporterOption(name="SerializationFeature.WRAP_ROOT_VALUE",value="true")
})

@JsonRootName("stockplex")
public class Stockplex implements ComponentExporter {

    @ScriptVariable
    private Resource resource;

    @ValueMapValue
   // @JsonIgnore
    private String symbol;

    @Reference
    MultiService multiService;

    public String getServiceName(){
        return multiService.getName()+"kalyan";
    }


    // property on the current resource saved from the dialog of a component
    @ValueMapValue
    private String summary;

    // property on the current resource saved from the dialog of a component

    @ValueMapValue
    private String showStockDetails;

    /**
     * All getter methods below will be apart of the output by the JSON Exporter
     */
    // Getter for dialog input
    public String getSymbol() {
        return symbol;
    }

    // Getter for dialog input
    public String getSummary() {
        return summary;
    }

    // Getter for dialog input
    public String getShowStockDetails() {
        return showStockDetails;
    }

    @Override
    public String getExportedType() {

        return resource.getResourceType();

    }

}
