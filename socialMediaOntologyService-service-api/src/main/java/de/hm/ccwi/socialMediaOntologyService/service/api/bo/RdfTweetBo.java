package de.hm.ccwi.socialMediaOntologyService.service.api.bo;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import de.hm.ccwi.socialMediaOntologyService.base.dto.Triplet;

/**
 * Rdf-Search-Businessobject.
 */
public class RdfTweetBo extends AbstractBo {

	/**
	 * This flag defines, whether or not the subject should be included into
	 * search.
	 */
	private Boolean searchSubject;

	/**
	 * The subject to search for. If the subject is null but the Boolean-Flag is
	 * true, then a wildcard-search on subject will be executed.
	 */
	private String subjectForSearch;

	/**
	 * This flag defines, whether or not the predicate should be included into
	 * search.
	 */
	private Boolean searchPredicate;

	/**
	 * The subject to search for. If the predicate is null but the Boolean-Flag
	 * is true, then a wildcard-search on subject will be executed.
	 */
	private String predicateForSearch;

	/**
	 * This flag defines, whether or not the object should be included into
	 * search.
	 */
	private Boolean searchObject;

	/**
	 * The subject to search for. If the object is null but the Boolean-Flag is
	 * true, then a wildcard-search on subject will be executed.
	 */
	private String objectForSearch;

	/**
	 * The Path of the resources.
	 */
	private String uri;

	/**
	 * The Model-Name of the resources.
	 */
	private String model;

	/**
	 * Triplet-List of RDF-Data
	 */
	private List<Triplet<String, String, String>> tripleList;

	/**
	 * Default-Constructor.
	 */
	public RdfTweetBo() {
	}

	/**
	 * Constructor for all attributes.
	 * 
	 * @param searchSubject
	 * @param subjectForSearch
	 * @param searchPredicate
	 * @param predicateForSearch
	 * @param searchObject
	 * @param objectForSearch
	 * @param uri
	 * @param model
	 * @param tripleList
	 */
	public RdfTweetBo(Boolean searchSubject, String subjectForSearch, Boolean searchPredicate,
			String predicateForSearch, Boolean searchObject, String objectForSearch, String uri, String model,
			List<Triplet<String, String, String>> tripleList) {
		super();
		this.searchSubject = searchSubject;
		this.subjectForSearch = subjectForSearch;
		this.searchPredicate = searchPredicate;
		this.predicateForSearch = predicateForSearch;
		this.searchObject = searchObject;
		this.objectForSearch = objectForSearch;
		this.uri = uri;
		this.model = model;
		this.tripleList = tripleList;
	}

	public Boolean getSearchPredicate() {
		return searchPredicate;
	}

	public void setSearchPredicate(Boolean searchPredicate) {
		this.searchPredicate = searchPredicate;
	}

	public String getPredicateForSearch() {
		return predicateForSearch;
	}

	public void setPredicateForSearch(String predicateForSearch) {
		this.predicateForSearch = predicateForSearch;
	}

	public Boolean getSearchObject() {
		return searchObject;
	}

	public void setSearchObject(Boolean searchObject) {
		this.searchObject = searchObject;
	}

	public String getObjectForSearch() {
		return objectForSearch;
	}

	public void setObjectForSearch(String objectForSearch) {
		this.objectForSearch = objectForSearch;
	}

	public Boolean getSearchSubject() {
		return searchSubject;
	}

	public void setSearchSubject(Boolean searchSubject) {
		this.searchSubject = searchSubject;
	}

	public String getSubjectForSearch() {
		return subjectForSearch;
	}

	public void setSubjectForSearch(String subjectForSearch) {
		this.subjectForSearch = subjectForSearch;
	}

	public List<Triplet<String, String, String>> getTripleList() {
		return tripleList;
	}

	public void setTripleList(List<Triplet<String, String, String>> rdfTweetResult) {
		this.tripleList = rdfTweetResult;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
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
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
