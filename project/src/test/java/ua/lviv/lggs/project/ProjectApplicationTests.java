package ua.lviv.lggs.project;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import ua.lviv.lgs.Application;
import ua.lviv.lgs.dao.BucketRepository;
import ua.lviv.lgs.dao.ScoresRepository;
import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Scores;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.domain.UserRole;
import ua.lviv.lgs.service.BucketService;
import ua.lviv.lgs.service.ScoresService;
import ua.lviv.lgs.service.UserService;

@ContextConfiguration(classes=Application.class)
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProjectApplicationTests {
	@Autowired
	private UserService userService;

	@Autowired
	private ScoresService scoresService;

	@Autowired
	private BucketService bucketService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ScoresRepository scoresRepository;

	@Autowired
	private BucketRepository bucketRepository;
	@Test
	public void testSaveUser() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User user = new User();
		user.setEmail("2");
		user.setFirstName("2");
		user.setLastName("2");
		user.setPassword("2");
		user.setPasswordConfirm("2");
		user.setRole(UserRole.ROLE_USER);

		userService.save(user);

		users = userRepository.findAll();
		assertThat(users, hasSize(1));

		User userFromDb = users.get(0);
		assertTrue(userFromDb.getEmail().equals(user.getEmail()));
		assertTrue(userFromDb.getFirstName().equals(user.getFirstName()));
		assertTrue(userFromDb.getLastName().equals(user.getLastName()));
		assertTrue(userFromDb.getRole().equals(user.getRole()));
	}
	@Test
	public void testFindByEmail() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User user = new User();
		user.setEmail("myCustomEmail@gmail.com");
		user.setFirstName("2");
		user.setLastName("2");
		user.setPassword("2");
		user.setPasswordConfirm("2");
		user.setRole(UserRole.ROLE_USER);

		userRepository.save(user);

		users = userRepository.findAll();
		assertThat(users, hasSize(1));

		User findByEmail = userService.findByEmail(user.getEmail());

		assertTrue(findByEmail.getEmail().equals(user.getEmail()));
		assertTrue(findByEmail.getFirstName().equals(user.getFirstName()));
		assertTrue(findByEmail.getLastName().equals(user.getLastName()));
		assertTrue(findByEmail.getRole().equals(user.getRole()));
	}

	@Test
	public void testSaveScores() {
		List<Scores> lisfOfScores = scoresRepository.findAll();
		assertThat(lisfOfScores, hasSize(0));

		Scores scores = new Scores();
		scores.setMath(1.0);
		scores.setPhysics(1.0);
		scores.setEnglish(1.0);
		scores.setEncodedImage("1");

		scoresService.save(scores);

		lisfOfScores = scoresRepository.findAll();
		assertThat(lisfOfScores, hasSize(1));

		Scores scoresFromDb = lisfOfScores.get(0);
		assertTrue(scoresFromDb.getMath().equals(scores.getMath()));
		assertTrue(scoresFromDb.getPhysics().equals(scores.getPhysics()));
		assertTrue(scoresFromDb.getEncodedImage().equals(scores.getEncodedImage()));
		assertTrue(scoresFromDb.getEnglish().equals(scores.getEnglish()));
	}

	@Test
	public void testFindById() {
		List<Scores> lisfOfScores = scoresRepository.findAll();
		assertThat(lisfOfScores, hasSize(0));

		Scores scores = new Scores();
		scores.setMath(1.0);
		scores.setPhysics(1.0);
		scores.setEnglish(1.0);
		scores.setEncodedImage("1");

		scoresRepository.save(scores);

		lisfOfScores = scoresRepository.findAll();
		assertThat(lisfOfScores, hasSize(1));

		Scores scoresFromDb = scoresService.findById(lisfOfScores.get(0).getId());
		assertTrue(scoresFromDb.getMath().equals(scores.getMath()));
		assertTrue(scoresFromDb.getPhysics().equals(scores.getPhysics()));
		assertTrue(scoresFromDb.getEncodedImage().equals(scores.getEncodedImage()));
		assertTrue(scoresFromDb.getEnglish().equals(scores.getEnglish()));
	}

	@Test
	public void testGetAllScores() {
		List<Scores> lisfOfScores = scoresRepository.findAll();
		assertThat(lisfOfScores, hasSize(0));

		Scores scores = new Scores();
		scores.setMath(1.0);
		scores.setPhysics(1.0);
		scores.setEnglish(1.0);
		scores.setEncodedImage("1");

		Scores scores2 = new Scores();
		scores2.setMath(21.0);
		scores2.setPhysics(21.0);
		scores2.setEnglish(21.0);
		scores2.setEncodedImage("21");
		
		scoresRepository.saveAll(Arrays.asList(scores,scores2));

		lisfOfScores = scoresRepository.findAll();
		assertThat(lisfOfScores, hasSize(2));

		List<Scores> listOfScoresFromDb = scoresService.getAllScores();
		assertTrue(listOfScoresFromDb.get(0).getMath().equals(scores.getMath()));
		assertTrue(listOfScoresFromDb.get(0).getPhysics().equals(scores.getPhysics()));
		assertTrue(listOfScoresFromDb.get(0).getEncodedImage().equals(scores.getEncodedImage()));
		assertTrue(listOfScoresFromDb.get(0).getEnglish().equals(scores.getEnglish()));
		
		assertTrue(listOfScoresFromDb.get(1).getMath().equals(scores2.getMath()));
		assertTrue(listOfScoresFromDb.get(1).getPhysics().equals(scores2.getPhysics()));
		assertTrue(listOfScoresFromDb.get(1).getEncodedImage().equals(scores2.getEncodedImage()));
		assertTrue(listOfScoresFromDb.get(1).getEnglish().equals(scores2.getEnglish()));
	}

	@Test
	public void testAddToBucket() {
		User user = new User();
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setRole(UserRole.ROLE_USER);

		userService.save(user);

		User userFromDb = userRepository.findAll().stream().findFirst().get();

		List<Scores> lisfOfScores = scoresRepository.findAll();
		assertThat(lisfOfScores, hasSize(0));

		Scores scores = new Scores();
		scores.setMath(21.0);
		scores.setPhysics(21.0);
		scores.setEnglish(21.0);
		scores.setEncodedImage("21");

		scoresRepository.save(scores);

		Scores scoresFromDb = scoresRepository.findAll().stream().findFirst().get();

		Date now = new Date();
		Bucket bucket = new Bucket();
		bucket.setScores(scoresFromDb);
		bucket.setUser(userFromDb);
		bucket.setPurchaseDate(now);

		List<Bucket> buckets = bucketRepository.findAll();
		assertThat(buckets, hasSize(0));

		bucketService.add(bucket);

		buckets = bucketRepository.findAll();
		assertThat(buckets, hasSize(1));

		Bucket bucketFromDb = buckets.get(0);

		assertTrue(bucketFromDb.getScores().equals(scoresFromDb));
		assertTrue(bucketFromDb.getUser().equals(userFromDb));
		assertTrue(bucketFromDb.getPurchaseDate().equals(now));
	}

	@Test
	public void testDeleteFromBucket() {
		User user = new User();
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setRole(UserRole.ROLE_USER);

		userService.save(user);

		User userFromDb = userRepository.findAll().stream().findFirst().get();

		List<Scores> lisfOfScores = scoresRepository.findAll();
		assertThat(lisfOfScores, hasSize(0));

		Scores scores = new Scores();
		scores.setMath(21.0);
		scores.setPhysics(21.0);
		scores.setEnglish(21.0);
		scores.setEncodedImage("21");

		Scores scores2 = new Scores();
		scores2.setMath(212.0);
		scores2.setPhysics(212.0);
		scores2.setEnglish(212.0);
		scores2.setEncodedImage("212");

		scoresRepository.saveAll(Arrays.asList(scores,scores2));

		List<Scores> scoresFromDb = scoresRepository.findAll();

		Date now = new Date();
		Bucket bucket = new Bucket();
		bucket.setScores(scoresFromDb.get(0));
		bucket.setUser(userFromDb);
		bucket.setPurchaseDate(now);

		Bucket bucket2 = new Bucket();
		bucket2.setScores(scoresFromDb.get(1));
		bucket2.setUser(userFromDb);
		bucket2.setPurchaseDate(now);

		List<Bucket> buckets = bucketRepository.findAll();
		assertThat(buckets, hasSize(0));

		bucketRepository.saveAll(Arrays.asList(bucket, bucket2));

		buckets = bucketRepository.findAll();
		assertThat(buckets, hasSize(2));

		bucketService.delete(buckets.get(0));

		buckets = bucketRepository.findAll();
		assertThat(buckets, hasSize(1));
	}

	@Test
	public void testGetAll() {
		User user = new User();
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setRole(UserRole.ROLE_USER);

		userService.save(user);

		User userFromDb = userRepository.findAll().stream().findFirst().get();

		List<Scores> lisfOfScores = scoresRepository.findAll();
		assertThat(lisfOfScores, hasSize(0));

		Scores scores = new Scores();
		scores.setMath(21.0);
		scores.setPhysics(21.0);
		scores.setEnglish(21.0);
		scores.setEncodedImage("21");

		Scores scores2 = new Scores();
		scores2.setMath(212.0);
		scores2.setPhysics(212.0);
		scores2.setEnglish(212.0);
		scores2.setEncodedImage("212");

		scoresRepository.saveAll(Arrays.asList(scores,scores2));

		List<Scores> scoresFromDb = scoresRepository.findAll();

		Date now = new Date();
		Bucket bucket = new Bucket();
		bucket.setScores(scoresFromDb.get(0));
		bucket.setUser(userFromDb);
		bucket.setPurchaseDate(now);

		Bucket bucket2 = new Bucket();
		bucket2.setScores(scoresFromDb.get(1));
		bucket2.setUser(userFromDb);
		bucket2.setPurchaseDate(now);

		List<Bucket> buckets = bucketRepository.findAll();
		assertThat(buckets, hasSize(0));

		bucketRepository.saveAll(Arrays.asList(bucket, bucket2));

		List<Bucket> bucketsFromDb = bucketService.getAll();
		assertThat(bucketsFromDb, hasSize(2));
	}
}


