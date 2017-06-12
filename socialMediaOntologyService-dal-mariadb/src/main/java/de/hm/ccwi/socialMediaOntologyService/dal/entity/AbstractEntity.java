package de.hm.ccwi.socialMediaOntologyService.dal.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	// protected static final String ID_GENERATOR_NAME = "sequenceGenerator";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // (strategy =
														// GenerationType.SEQUENCE,
														// generator =
														// ID_GENERATOR_NAME)
	private Long id;

	public AbstractEntity() {
		super();
	}

	public AbstractEntity(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
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
