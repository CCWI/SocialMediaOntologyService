//package de.hm.ccwi.socialMediaOntologyService.dal.repo;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.equalTo;
//
//import javax.inject.Inject;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.experimental.categories.Category;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
//
//import de.hm.ccwi.socialMediaOntologyService.base.testconfig.category.IntegrationTest;
//import de.hm.ccwi.socialMediaOntologyService.dal.TestDaoConfig;
//import de.hm.ccwi.socialMediaOntologyService.dal.entity.UserEntity;
//import de.hm.ccwi.socialMediaOntologyService.dal.repo.UserRepository;
//
//@ContextConfiguration(classes = { TestDaoConfig.class })
//@Category(IntegrationTest.class)
//public class UserRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
//
//	@Inject
//	private UserRepository sut;
//
//	private UserEntity userEntity;
//
//	@Before
//	public void setUp() {
//		userEntity = new UserEntity();
//		userEntity.setUsername("user123");
//		userEntity.setPassword("321");
//		userEntity = sut.save(userEntity);
//	}
//
//	@Test
//	public void testFindFirstByUsername() {
//		final UserEntity result = sut.findFirstByUsername(userEntity.getUsername());
//		assertThat(result, is(equalTo(userEntity)));
//	}
//}
