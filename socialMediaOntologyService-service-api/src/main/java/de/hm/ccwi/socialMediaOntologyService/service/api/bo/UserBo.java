package de.hm.ccwi.socialMediaOntologyService.service.api.bo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * User-Businessobjekt.
 */
public class UserBo extends AbstractBo implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	private boolean enabled;

	private Set<RoleBo> roles;

	/**
	 * Default-Konstruktor.
	 */
	public UserBo() {
	}

	public UserBo(String username, String password, boolean enabled, Set<RoleBo> roles) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(final boolean enabled) {
		this.enabled = enabled;
	}

	public Set<RoleBo> getRoles() {
		return roles;
	}

	public void setRoles(final Set<RoleBo> roles) {
		this.roles = roles;
	}

	@Override
	public boolean equals(final Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		final Collection<GrantedAuthority> authorities = new HashSet<>();
		if (CollectionUtils.isNotEmpty(roles)) {
			for (final RoleBo role : roles) {
				authorities.addAll(toGrantedAuthorities(role));
			}
		}
		return authorities;
	}

	private Collection<GrantedAuthority> toGrantedAuthorities(final RoleBo role) {
		final Collection<GrantedAuthority> authorities = new ArrayList<>();
		for (final String permission : role.getRole().getPermissions()) {
			authorities.add(new SimpleGrantedAuthority(permission));
		}
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

}
