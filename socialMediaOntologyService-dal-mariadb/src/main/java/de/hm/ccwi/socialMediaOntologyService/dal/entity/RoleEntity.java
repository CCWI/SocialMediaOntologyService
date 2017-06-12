//package de.hm.ccwi.socialMediaOntologyService.dal.entity;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.Table;
//
//import org.apache.commons.lang3.builder.EqualsBuilder;
//import org.apache.commons.lang3.builder.HashCodeBuilder;
//
//import de.hm.ccwi.socialMediaOntologyService.base.security.Role;
//
////@SequenceGenerator(name = AbstractEntity.ID_GENERATOR_NAME, sequenceName = "SEQ_ROLE", initialValue = 1, allocationSize = 1)
///**
// * Rollenentität.
// */
//@Entity
//@Table(name = "ROLE")
//public class RoleEntity extends AbstractEntity implements Serializable {
//
//	@Column(nullable = false)
//	@Enumerated(EnumType.STRING)
//	private Role role;
//
//	public RoleEntity() {
//		super();
//	}
//
//	public RoleEntity(Role role) {
//		super();
//		this.role = role;
//	}
//
//	public Role getRole() {
//		return role;
//	}
//
//	public void setRole(final Role role) {
//		this.role = role;
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