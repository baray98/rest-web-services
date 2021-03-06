package com.bcompany.rest.webservices.restwebservices.User;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;
	//get all users

	@GetMapping(path="/users")
	public List<User> retrieveAllUser()
	{
		return service.findAll();
	}
	@GetMapping(path="/users/{id}")
	public User retrieveUser(@PathVariable int id)
	{
		User user =  service.findOne(id);
		if (user ==  null)
			throw new UserNotFoundException("id-"+id);
		return user;
	}
	@DeleteMapping(path="/users/{id}")
	public User deleteUser(@PathVariable int id)
	{
		User user =  service.deleteById(id);
		if (user ==  null)
			throw new UserNotFoundException("id-"+id);
		return user;
	}
	@PostMapping(path = "/users")
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		User savedUser = service.save(user);
		//return status CREATED
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id})")
		.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();

	}

}
