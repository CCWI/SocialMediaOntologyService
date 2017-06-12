package de.hm.ccwi.socialMediaOntologyService.security;

import de.hm.ccwi.socialMediaOntologyService.base.security.Permission;
import de.hm.ccwi.socialMediaOntologyService.base.security.Role;
import de.hm.ccwi.socialMediaOntologyService.service.api.UserService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.inject.Inject;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Profile(SecurityProfiles.PROFILE_NO_SSL)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static boolean IN_MEMORY_AUTHENTICATION_ENABLED = false;

	@Inject
	private UserService userService;

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		if (IN_MEMORY_AUTHENTICATION_ENABLED) {
			configureInMemoryAuthenticationManager(auth);
		} else {
			configureDatabaseAuthenticationManager(auth);
		}
	}

	private void configureInMemoryAuthenticationManager(final AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()//
				.withUser("admin").password("admin").authorities(Role.ADMIN.getPermissions()) //
				.and().withUser("reader").password("reader").authorities(Role.READER.getPermissions()) //
				.and().withUser("writer").password("writer").authorities(Role.WRITER.getPermissions());
	}

	private void configureDatabaseAuthenticationManager(final AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
	}

	@Bean
	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return super.userDetailsServiceBean();
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().hasAuthority(Permission.PERMISSION_ACCESS_APP_URLS).and().httpBasic()
				.and().csrf().disable().anonymous().disable();
	}

}
