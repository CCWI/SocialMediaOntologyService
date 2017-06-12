package de.hm.ccwi.socialMediaOntologyService.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@Profile(SecurityProfiles.PROFILE_SSL)
public class SecurityConfigSsl extends SecurityConfig {

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		super.configure(http);
		http.requiresChannel().anyRequest().requiresSecure();
	}

}
