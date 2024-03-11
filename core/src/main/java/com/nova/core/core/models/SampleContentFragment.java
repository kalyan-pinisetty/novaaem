package com.nova.core.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.dam.cfm.ContentElement;
import com.adobe.cq.dam.cfm.ContentFragment;

import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

@Model(adaptables = Resource.class)

public class SampleContentFragment {
    public static final String PATH = "/content/dam/nova/cardscf/lisahunter";
    @Inject
    @Self
    private Resource resource;

    @Inject
    ResourceResolver resolver;
    private Optional <ContentFragment> contentFragment;

    @PostConstruct
    public void init() {
        resolver = resource.getResourceResolver();
        Resource fragmentResource = resolver.getResource(PATH);
        contentFragment = Optional.ofNullable(fragmentResource.adaptTo(ContentFragment.class));

    }
    public String getCardImg() {
        return contentFragment.map(cf -> cf.getElement("CardImg")).map(ContentElement::getContent)
                .orElse(StringUtils.EMPTY);
    }

    public String getCardDateTitle() {
        return contentFragment.map(cf -> cf.getElement("CardDateTitle")).map(ContentElement::getContent)
                .orElse(StringUtils.EMPTY);

    }

    public String getCardTitle() {
        return contentFragment.map(cf -> cf.getElement("CardTitle")).map(ContentElement::getContent)
                .orElse(StringUtils.EMPTY);

    }

    public String getCardDescription() {
        return contentFragment.map(cf -> cf.getElement("CardDescription")).map(ContentElement::getContent)
                .orElse(StringUtils.EMPTY);

    }

    public String getCardLinkv() {
        return contentFragment.map(cf -> cf.getElement("CardLinkv")).map(ContentElement::getContent)
                .orElse(StringUtils.EMPTY);

    }
}
