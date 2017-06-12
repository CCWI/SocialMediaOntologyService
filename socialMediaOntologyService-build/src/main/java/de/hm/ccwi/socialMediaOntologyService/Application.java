package de.hm.ccwi.socialMediaOntologyService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * Initializing the SpringBoot-Application.
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class })
@PropertySources({
	@PropertySource("application.yml"),
	@PropertySource("application.properties"),
	@PropertySource("bootstrap.properties")
})
@EnableConfigurationProperties
@Configuration
@ComponentScan
public class Application {

	public static void main(final String[] args) {
//		initializeSystemDefaults();
		SpringApplication.run(Application.class, args);
	}

//	private static void initializeSystemDefaults() {
//		TimeZone.setDefault(TimeZone.getTimeZone("Europe/Berlin"));
//		Locale.setDefault(Locale.GERMAN);
//	}

}
