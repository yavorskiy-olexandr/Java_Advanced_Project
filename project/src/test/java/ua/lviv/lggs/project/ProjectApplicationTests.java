package ua.lviv.lggs.project;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import ua.lviv.lgs.Application;
import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.domain.UserRole;
import ua.lviv.lgs.service.UserService;

//@SpringBootTest(classes=Application.class)
@ContextConfiguration(classes=Application.class)
//@WebMvcTest(MyController.class)
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProjectApplicationTests {
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void contextLoads() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User user = new User(1,"1", "1", "1", UserRole.ROLE_USER, "1");
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setRole(UserRole.ROLE_USER);

		userService.save(user);

		users = userRepository.findAll();
		assertThat(users, hasSize(1));
	}

}


