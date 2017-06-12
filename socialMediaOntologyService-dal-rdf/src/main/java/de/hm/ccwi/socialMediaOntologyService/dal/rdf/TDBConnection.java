package de.hm.ccwi.socialMediaOntologyService.dal.rdf;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Selector;
import org.apache.jena.rdf.model.SimpleSelector;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.tdb.TDBFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Class for CRUD operations on TDB-backed Models
 */
public class TDBConnection {
	
	private Dataset ds;

	// @Value("${database.rdf.jena.path}")
	private String path = "./src/main/resources/";

	public TDBConnection(String path) {
		ds = TDBFactory.createDataset(path);
	}

	/**
	 * get a model for the given directory
	 * 
	 * @param directory
	 * @return
	 */
	public Model getModel() {
		ds.begin(ReadWrite.READ);
		Model model = ds.getDefaultModel();
		ds.end();
		return model;
	}

	/**
	 * save the given model
	 * 
	 * @param model
	 */
	public void saveModel(Model model) {
		if (model != null && ds != null) {
			model.commit();
			model.close();
			ds.close();
		}
	}

	/**
	 * Request triples from the TDB back-end
	 * 
	 * @param modelName
	 *            - graph identifier
	 * @return statements that fit the s-p-o description
	 */
	public List<Statement> getStatements(String modelName, String subject, String property, String object) {
		List<Statement> results = new ArrayList<Statement>();

		Model model = null;

		ds.begin(ReadWrite.READ);
		try {
			model = ds.getNamedModel(modelName);

			Resource s = (subject != null) ? model.createResource(subject) : (Resource) null;
			Property p = (property != null) ? model.createProperty(property) : (Property) null;
			RDFNode o = (object != null) ? model.createResource(object) : (RDFNode) null;
			Selector selector = new SimpleSelector(s, p, o);

			StmtIterator it = model.listStatements(selector);
			{
				while (it.hasNext()) {
					Statement stmt = it.next();
					results.add(stmt);
				}
			}

			ds.commit();
		} finally {
			// if (model != null)
			// model.close();
			ds.end();
		}

		return results;
	}

	/**
	 * Add a statement to the TDB back-end for the given UserSession Model
	 * 
	 * @param modelName
	 *            - graph identifier
	 * @throws RdfException
	 */
	public void addStatement(String modelName, String subject, String property, String object) throws RdfException {
		Model model = null;

		ds.begin(ReadWrite.WRITE);
		try {
			model = ds.getNamedModel(modelName);

			Statement stmt = model.createStatement(model.createResource(subject), model.createProperty(property),
					model.createResource(object));

			model.add(stmt);
			ds.commit();
		} catch (Exception e) {
			throw new RdfException("was not able to exectue addStatement.");
		} finally {
			// if (model != null) {
			// model.close();
			// }
			ds.end();
		}
	}

	/**
	 * Remove a statement to the TDB Backend for the given UserSession Model
	 * 
	 * @param modelName
	 *            - graph identifier
	 */
	public void removeStatement(String modelName, String subject, String property, String object) {
		Model model = null;

		ds.begin(ReadWrite.WRITE);
		try {
			model = ds.getNamedModel(modelName);

			Statement stmt = model.createStatement(model.createResource(subject), model.createProperty(property),
					model.createResource(object));

			model.remove(stmt);
			ds.commit();
		} finally {
			// if (model != null)
			// model.close();
			ds.end();
		}
	}

	/**
	 * Close the dataset
	 */
	public void close() {
		ds.close();
	}

}
