package de.hm.ccwi.socialMediaOntologyService.integrationtest.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;

import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class IntegrationTestConfig {

	@Inject
	private ObjectMapper objectMapper;

	public void configure(String baseUri) {
		RestAssured.baseURI = baseUri;
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		authScheme.setUserName("writer");
		authScheme.setPassword("writer");
		RestAssured.authentication = authScheme;
		RestAssured.config = RestAssuredConfig.config()
				.objectMapperConfig(new ObjectMapperConfig().jackson2ObjectMapperFactory((aClass, s) -> objectMapper));
	}
}
