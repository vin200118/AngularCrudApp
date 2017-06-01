package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.domain.Message;
import com.company.domain.User;
import com.company.service.UserService;

@RestController
@RequestMapping("/department")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public ResponseEntity<?> getUsers(){
		List<User> usList = userService.getUsers();
		return new ResponseEntity<>(usList, HttpStatus.OK);
	}

	
	@RequestMapping(value="",method=RequestMethod.POST)
	public ResponseEntity<?> saveUsers(@RequestBody User user){
		userService.saveUser(user);
		Message message = new Message();
		message.setCode(HttpStatus.CREATED.name());
		message.setMessage("User created Succesfully.");
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable String id){
		userService.removeUser(id);
		Message message = new Message();
		message.setCode(HttpStatus.CREATED.name());
		message.setMessage("User deleted Succesfully.");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable String id){
		return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
	}
	

}
