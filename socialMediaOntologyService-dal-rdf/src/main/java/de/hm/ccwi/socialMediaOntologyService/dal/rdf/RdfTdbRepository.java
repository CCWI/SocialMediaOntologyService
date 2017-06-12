package de.hm.ccwi.socialMediaOntologyService.dal.rdf;

import java.util.List;

import de.hm.ccwi.socialMediaOntologyService.base.dto.Triplet;

public interface RdfTdbRepository {

	/**
	 * Request triples from the TDB backend.
	 * 
	 * @param modelName
	 * @param subject
	 * @param property
	 * @param object
	 * @param uri
	 * @return
	 */
	public List<Triplet<String, String, String>> getTriples(String modelName, String subject, String property,
			String object, String uri);

	/**
	 * Add a triple to the TDB backend for the given Model.
	 * 
	 * @param modelName
	 * @param subject
	 * @param property
	 * @param object
	 * @param uri
	 * @return
	 * @throws RdfException
	 */
	public void addTriples(String modelName, String subject, String property, String object, String uri)
			throws RdfException;

	/**
	 * Remove a triple to the TDB Backend for the given UserSession Model.
	 * 
	 * @param modelName
	 * @param subject
	 * @param property
	 * @param object
	 * @param uri
	 */
	public void removeTriples(String modelName, String subject, String property, String object, String uri);

	/**
	 * Creates a new TDBConnection.
	 * 
	 * @param tdbConnection
	 */
	public void openTDBConnection(String tdbConnection);

	/**
	 * Closes a TDBConnection.
	 */
	public void closeTDBConnection();
}
