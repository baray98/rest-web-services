package com.bcompany.rest.webservices.restwebservices.HelloWord.Test;

import static org.junit.Assert.*;
import org.junit.Test;

import com.bcompany.rest.webservices.restwebservices.User.UserDaoService;
import com.bcompany.rest.webservices.restwebservices.User.User;

public class UserDaoServiceTest {
//	@Autowired
//	private UserDaoService srv = new UserDaoService();
	
	@Test
	public void findOneTest() {
		
		UserDaoService srv = new UserDaoService();
		User user = srv.findOne(1);
		assertTrue(user.getId() == 1);
	}
	@Test
	public void deleteByIdTest() {
		
		UserDaoService srv = new UserDaoService();
		User user = srv.deleteById(1);
		assertTrue(user.getId() == 1);
	}
	
}
