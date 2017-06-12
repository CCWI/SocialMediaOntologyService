package de.hm.ccwi.socialMediaOntologyService.dal.rdf;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.rdf.model.Statement;
import org.springframework.stereotype.Service;

import de.hm.ccwi.socialMediaOntologyService.base.dto.Triplet;

/**
 * Nach http://tutorial-academy.com/apache-jena-tdb-crud-operations/
 */
@Service
public class RdfTdbRepositoryImpl implements RdfTdbRepository {

	private TDBConnection tdb;

	/**
	 * Default-Constructor
	 */
	public RdfTdbRepositoryImpl() {
		super();
	}

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
			String object, String uri) {
		List<Statement> statementList = null;
		if (uri != null) {
			statementList = tdb.getStatements(modelName, subject != null ? uri + subject : subject,
					property != null ? uri + property : null, object != null ? uri + object : null);
		} else {
			statementList = tdb.getStatements(modelName, subject, property, object);
		}

		List<Triplet<String, String, String>> tripleList = new ArrayList<Triplet<String, String, String>>();
		for (Statement s : statementList) {
			tripleList.add(new Triplet<String, String, String>(s.getSubject().getLocalName(),
					s.getPredicate().getLocalName(), s.getObject().toString()));
		}
		return tripleList;

	}

	/**
	 * Add a triple to the TDB back-end for the given UserSession Model.
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
			throws RdfException {
		if (uri != null) {
			tdb.addStatement(modelName, subject != null ? uri + subject : subject,
					property != null ? uri + property : null, object != null ? uri + object : null);
		} else {
			tdb.addStatement(modelName, subject, property, object);
		}
	}

	/**
	 * Remove a triple to the TDB Backend for the given UserSession Model.
	 * 
	 * @param modelName
	 * @param subject
	 * @param property
	 * @param object
	 * @param uri
	 */
	public void removeTriples(String modelName, String subject, String property, String object, String uri) {
		if (uri != null) {
			tdb.removeStatement(modelName, subject != null ? uri + subject : subject,
					property != null ? uri + property : null, object != null ? uri + object : null);
		} else {
			tdb.removeStatement(modelName, subject, property, object);
		}
	};

	/**
	 * Creates a new TDBConnection.
	 * 
	 * @param tdbConnection
	 */
	public void openTDBConnection(String tdbConnection) {
		if (tdbConnection != null) {
			this.tdb = new TDBConnection(tdbConnection);
		}
	}

	/**
	 * Closes a TDBConnection
	 */
	public void closeTDBConnection() {
		if (tdb != null) {
			tdb.close();
		}
	}
}
