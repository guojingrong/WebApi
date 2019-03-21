package com.jr.Common;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NameBinding;
import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthorizationFilterFeature implements DynamicFeature{


	
	@Override
	public void configure(ResourceInfo resourceInfo, FeatureContext context) {
		// TODO Auto-generated method stub
		/*
		 * List<Annotation> authzSpecs = new ArrayList<>();
		 * 
		 * Annotation classAuthzSpec =
		 * resourceInfo.getResourceClass().getAnnotation(AuthAnnotation.class);
		 * Annotation methodAuthzSpec =
		 * resourceInfo.getResourceMethod().getAnnotation(AuthAnnotation.class);
		 * 
		 * if (classAuthzSpec != null) authzSpecs.add(classAuthzSpec); if
		 * (methodAuthzSpec != null) authzSpecs.add(methodAuthzSpec);
		 * 
		 * if (!authzSpecs.isEmpty()) { // ÐèÒªÀ¹½ØµÄapi
		 * context.register(AuthorizationFilter.class); }
		 */
	}

}
