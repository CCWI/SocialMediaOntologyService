package de.hm.ccwi.socialMediaOntologyService.integrationtest;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import de.hm.ccwi.socialMediaOntologyService.base.testconfig.category.IntegrationTest;
import de.hm.ccwi.socialMediaOntologyService.integrationtest.config.IntegrationTestConfig;
import de.hm.ccwi.socialMediaOntologyService.service.api.TweetMigrationService;


//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT, value = "server.port=9000")
//@TestPropertySource(locations = { "classpath:bootstrap.properties", "classpath:application.properties" })
//@Category(IntegrationTest.class)
//public class MigrationTest {
//
//	private static final String HOST = "http://localhost:9000";
//
//	@Inject
//	private IntegrationTestConfig testConfig;
//	
//	@Inject
//	private TweetMigrationService migrationService;
//
//	@Before
//	public void setUp() {
//		testConfig.configure(HOST);
//	}
//
//	@Test
//	public void testMigration() {
//		migrationService.migrateRelationalTweetsToRdf();
//	}
//}
