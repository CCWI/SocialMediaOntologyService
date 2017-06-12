//package de.hm.ccwi.socialMediaOntologyService.dal.repo;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.notNullValue;
//
//import javax.inject.Inject;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.experimental.categories.Category;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
//
//import de.hm.ccwi.socialMediaOntologyService.base.security.Role;
//import de.hm.ccwi.socialMediaOntologyService.base.testconfig.category.IntegrationTest;
//import de.hm.ccwi.socialMediaOntologyService.dal.TestDaoConfig;
//import de.hm.ccwi.socialMediaOntologyService.dal.entity.RoleEntity;
//import de.hm.ccwi.socialMediaOntologyService.dal.repo.RoleRepository;
//
//@ContextConfiguration(classes = { TestDaoConfig.class })
//@Category(IntegrationTest.class)
//public class RoleRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
//
//	@Inject
//	private RoleRepository sut;
//
//	private RoleEntity roleEntity;
//
//	@Before
//	public void setUp() {
//		roleEntity = new RoleEntity();
//		roleEntity.setRole(Role.ADMIN);
//		roleEntity = sut.save(roleEntity);
//	}
//
//	@Test
//	public void testFindFirstByRole() {
//		final RoleEntity result = sut.findFirstByRole(Role.ADMIN);
//		assertThat(result, is(notNullValue()));
//		assertThat(result.getRole(), is(equalTo(Role.ADMIN)));
//	}
//}
