package com.nova.core.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Nova - Modular OSGi Configuration", 
                       description = "Modular OSGi configuration Demo.")
public @interface NovaOSGiConfig {

    @AttributeDefinition(
        name = "Service ID",
        description = "Enter Service ID",
        type = AttributeType.INTEGER)
        int serviceID();

     @AttributeDefinition(
        name = "Service Name",
        description = "Enter Service Name",
        type = AttributeType.STRING)
        String serviceName() default "Nova Service User";

     @AttributeDefinition(
        name = "Service URL",
        description = "Enter Service URL",
        type = AttributeType.STRING)
        String serviceURL() default "localhost";


}
