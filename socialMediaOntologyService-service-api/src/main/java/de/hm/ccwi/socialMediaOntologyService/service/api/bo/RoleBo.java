package de.hm.ccwi.socialMediaOntologyService.service.api.bo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import de.hm.ccwi.socialMediaOntologyService.base.security.Role;

/**
 * Rollen-Businessobjekt.
 */
public class RoleBo extends AbstractBo {

	private Role role;

	/**
	 * Default-Konstruktor.
	 */
	public RoleBo() {
	}

	public Role getRole() {
		return role;
	}

	public void setRole(final Role role) {
		this.role = role;
	}

	@Override
	public boolean equals(final Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

}
