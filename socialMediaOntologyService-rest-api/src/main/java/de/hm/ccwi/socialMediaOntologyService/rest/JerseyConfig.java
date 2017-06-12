package de.hm.ccwi.socialMediaOntologyService.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.stereotype.Component;

import de.hm.ccwi.socialMediaOntologyService.rest.resource.RdfTweetResource;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		registerResources();
		setProperties();
	}

	private void registerResources() {
		register(RdfTweetResource.class);
	}

	private void setProperties() {
		property(ServerProperties.BV_FEATURE_DISABLE, Boolean.TRUE);
	}

}
