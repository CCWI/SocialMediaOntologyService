package de.hm.ccwi.socialMediaOntologyService.base.security;

import org.apache.commons.lang3.Validate;

import de.hm.ccwi.socialMediaOntologyService.base.security.Permission;

public enum Role {

	READER("READER", Permission.PERMISSION_ACCESS_APP_URLS, Permission.PERMISSION_READ), //
	WRITER("WRITER", Permission.PERMISSION_ACCESS_APP_URLS, Permission.PERMISSION_READ, Permission.PERMISSION_SAVE), //
	ADMIN("ADMIN", Permission.PERMISSION_ACCESS_APP_URLS, Permission.PERMISSION_READ, Permission.PERMISSION_SAVE,
			Permission.PERMISSION_DELETE);

	private final String roleName;
	private final String[] permissions;

	private Role(final String roleName, final String... permissions) {
		Validate.notBlank(roleName);
		Validate.notEmpty(permissions);

		this.roleName = roleName;
		this.permissions = permissions;
	}

	public String getRoleName() {
		return roleName;
	}

	public String[] getPermissions() {
		return permissions;
	}

	@Override
	public String toString() {
		return getRoleName();
	}
}
