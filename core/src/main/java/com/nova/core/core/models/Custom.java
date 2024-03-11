package com.nova.core.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Custom {

    @Inject
	private List<CustomImpl> experience;

	public List<CustomImpl> getExperience() {

		return new ArrayList<>(experience);

	}


    @ValueMapValue
    @Optional
    private String[] states;

    @ValueMapValue
    @Optional
    private String textfield;

    @ValueMapValue
    @Optional
    private String date;

    @ValueMapValue
    @Optional
    private String pathbrowser;

    @ValueMapValue
    @Optional
    private boolean checkbox;

    @ValueMapValue
    @Optional
    private String radiobutton;

    @ValueMapValue
    @Optional
    private String dropdown;

    @Inject
    private String fileReference;

    public String getFileReference() {
        return fileReference;
    }

    public String[] getStates() {
        return states;
    }

    public String getTextfield() {
        return textfield;
    }

    public String getDate() {
        return date;
    }

    public String getPathbrowser() {
        return pathbrowser;
    }

    public boolean getCheckbox() {
        return checkbox;
    }

    public String getRadiobutton() {
        return radiobutton;
    }

    public String getDropdown() {
        return dropdown;
    }
}
