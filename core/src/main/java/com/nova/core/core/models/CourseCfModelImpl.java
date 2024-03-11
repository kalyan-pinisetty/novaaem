package com.nova.core.core.models;


import com.adobe.cq.dam.cfm.ContentElement;
import com.adobe.cq.dam.cfm.ContentFragment;
import java.text.ParseException;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CourseCfModelImpl implements CourseCfModel {
	
	 private String carddatetitle;
	 
	 private String cardimg;
	 
	 private String cardtitle;
	    
	 private String carddescription;
	    
	 private String cardlink;
	 
	 
	
	public CourseCfModelImpl(Optional<ContentFragment> contentFragment) throws ParseException  {
		
		 cardimg=contentFragment.map(cf -> cf.getElement("CardImg")).map(ContentElement::getContent).orElse(StringUtils.EMPTY);
		 
		 carddatetitle=contentFragment.map(cf -> cf.getElement("CardDateTitle")).map(ContentElement::getContent).orElse(StringUtils.EMPTY);
		 	 
		 cardtitle=contentFragment.map(cf -> cf.getElement("CardTitle")).map(ContentElement::getContent).orElse(StringUtils.EMPTY);
		 
		 carddescription=contentFragment.map(cf -> cf.getElement("CardDescription")).map(ContentElement::getContent).orElse(StringUtils.EMPTY);
		 
		cardlink=contentFragment.map(cf -> cf.getElement("CardLink")).map(ContentElement::getContent).orElse(StringUtils.EMPTY);
	}

	

	@Override
	public String getCardImg() {
		// TODO Auto-generated method stub
		return cardimg;
	}

	@Override
	public String getCardDateTitle() {
		// TODO Auto-generated method stub
		return carddatetitle;
	}

	@Override
	public String getCardTitle() {
		// TODO Auto-generated method stub
		return cardtitle;
	}

	@Override
	public String getCardDescription() {
		// TODO Auto-generated method stub
		return carddescription;
	}

	@Override
	public String getCardLink() {
		// TODO Auto-generated method stub
		return cardlink;
	}
		
}

