package com.nova.core.core.models.impl;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

import com.day.cq.wcm.api.Page;
import com.nova.core.core.models.CustomText;

@Model(adaptables = SlingHttpServletRequest.class,adapters=CustomText.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CustomTextImpl implements CustomText {

    @ScriptVariable
    Page currentPage;

    @Inject
    @Via("resource")
    @Default(values = "Pawan Kalyan")
    private String value;

    @ValueMapValue
    @Default(values = "Bhavagna.Bullama@2543")
    private String email;

    @Inject
    @Via("resource")
    private String generateid;

    @ValueMapValue
    private String dob;

    @ValueMapValue
    private String title;

    @Override
    public String getName() {
        return value;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getGenerateId() {
        return generateid;
    }

    @Override
    public String getDob() {
        return dob;
    }

    @Override
    public String getTitle() {
        return title;
    }

     @Override
    public String getPageTitle() {
        return currentPage.getTitle();
    }

}
