package com.bcompany.rest.webservices.restwebservices.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import javassist.bytecode.Descriptor.Iterator;

@Component

public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static int userCount = 3;
	public UserDaoService() {
		super();
		// TODO Auto-generated constructor stub
		users.add(new User(1,"Bryan",new Date()));
		users.add(new User(2,"Rubia",new Date()));
		users.add(new User(3,"Berna",new Date()));
	}

	public List<User> findAll(){
		return users;
	}

	public User save(User user)
	{
		if (user.getId() == null)
		{
			user.setId(++userCount);
		}

		users.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user:users) {
			if (user.getId() == id)
			{
				return user;
			}
		}
		return null;
	}

	public User deleteById(int id) {

		java.util.Iterator<User> iterator = users.iterator();
		
		while (iterator.hasNext()) 
		{
			User user = iterator.next();
			if (user.getId() == id) 
			{
				iterator.remove();
				return user;
			}
		}

		return null;

	}
}
