package de.hm.ccwi.socialMediaOntologyService.base.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.Identifiable;
import org.springframework.hateoas.Link;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AbstractDto implements Identifiable<Long> {

	@XmlElement
	private Long id;

	@XmlElementWrapper(name = "links")
	@XmlElement(name = "link", namespace = Link.ATOM_NAMESPACE)
	@JsonProperty("links")
	private final Collection<Link> links = new ArrayList<>();

	/**
	 * Default-Constructor.
	 */
	public AbstractDto() {
	}

	/**
	 * Constructor with id.
	 *
	 * @param id
	 */
	public AbstractDto(final Long id) {
		this();
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Collection<Link> getLinks() {
		return links;
	}

}
