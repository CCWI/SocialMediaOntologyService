//package de.hm.ccwi.socialMediaOntologyService.dal.entity;
//
//import java.io.Serializable;
//import java.util.Set;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//import javax.persistence.UniqueConstraint;
//
//import org.apache.commons.lang3.builder.EqualsBuilder;
//import org.apache.commons.lang3.builder.HashCodeBuilder;
//
////@SequenceGenerator(name = AbstractEntity.ID_GENERATOR_NAME, sequenceName =
////"SEQ_USER", initialValue = 1, allocationSize = 1)
//
///**
// * User-Entität.
// */
//@Entity
//@Table(name = "USERDATA")
//public class UserEntity extends AbstractEntity implements Serializable {
//
//	@Column(nullable = false)
//	private String username;
//
//	@Column(nullable = false)
//	private String password;
//
//	@Column(nullable = false)
//	private boolean enabled;
//
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "USER_ROLES", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"), uniqueConstraints = @UniqueConstraint(columnNames = {
//			"USER_ID", "ROLE_ID" }))
//	private Set<RoleEntity> roles;
//
//	public UserEntity() {
//		super();
//	}
//
//	public UserEntity(String username, String password, boolean enabled, Set<RoleEntity> roles) {
//		super();
//		this.username = username;
//		this.password = password;
//		this.enabled = enabled;
//		this.roles = roles;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(final String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(final String password) {
//		this.password = password;
//	}
//
//	public boolean isEnabled() {
//		return enabled;
//	}
//
//	public void setEnabled(final boolean enabled) {
//		this.enabled = enabled;
//	}
//
//	public Set<RoleEntity> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(final Set<RoleEntity> roles) {
//		this.roles = roles;
//	}
//
//	@Override
//	public boolean equals(final Object obj) {
//		return EqualsBuilder.reflectionEquals(this, obj);
//	}
//
//	@Override
//	public int hashCode() {
//		return HashCodeBuilder.reflectionHashCode(this);
//	}
//}