package de.hm.ccwi.semanticWebService.dal.rdf;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import de.hm.ccwi.socialMediaOntologyService.base.dto.Triplet;
import de.hm.ccwi.socialMediaOntologyService.base.testconfig.category.IntegrationTest;
import de.hm.ccwi.socialMediaOntologyService.dal.rdf.RdfException;
import de.hm.ccwi.socialMediaOntologyService.dal.rdf.RdfTdbRepository;
import de.hm.ccwi.socialMediaOntologyService.dal.rdf.RdfTdbRepositoryImpl;

@RunWith(MockitoJUnitRunner.class)
@Category(IntegrationTest.class)
public class RdfTdbRepositoryTest {

	private RdfTdbRepository repo;
	private String namedModel = "TestModel";
	private String testSubject;
	private String testProperty;
	private String testObject1;
	private String testObject2;

	@Before
	public void initialize() {
		testSubject = "Max";
		testProperty = "owns";
		testObject1 = "BMW";
		testObject2 = "Mercedes";
	}

	@Test
	public void tdbRepositoryCrudTest() {

		repo = new RdfTdbRepositoryImpl();

		repo.openTDBConnection("./src/main/resources/");

		try {
			addEntries();

			List<Triplet<String, String, String>> result;
			getEntries();
			//TODO assert(result)!

			removeEntries();
			//TODO assert()!
		} finally {
			repo.closeTDBConnection();
		}
	}

	private void removeEntries() {
		repo.removeTriples(namedModel, testSubject, testProperty, testObject1,
				"http://localhost:3030/$/stats/tdb#");
		repo.removeTriples(namedModel, testSubject, testProperty, testObject2,
				"http://localhost:3030/$/stats/tdb#");
	}

	private void getEntries() {
		List<Triplet<String, String, String>> result = repo.getTriples(namedModel, null, null, testObject1,
				"http://localhost:3030/$/stats/tdb#");
		System.out.println(namedModel + " size: " + result.size() + "\n\t" + result);

		result = repo.getTriples(namedModel, testSubject, null, null, "http://localhost:3030/$/stats/tdb#");
		System.out.println(namedModel + " size: " + result.size() + "\n\t" + result);
	}

	private void addEntries() {
		try {
			repo.addTriples(namedModel, testSubject, testProperty, testObject1,
					"http://localhost:3030/$/stats/tdb#");
			repo.addTriples(namedModel, testSubject, testProperty, testObject2,
					"http://localhost:3030/$/stats/tdb#");
		} catch (RdfException e) {
			e.printStackTrace();
		}
	}
}
