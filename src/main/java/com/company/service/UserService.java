package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.domain.User;
import com.company.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> getUsers() {
		return userRepository.getUsers();
	}

	public void saveUser(User user) {
		userRepository.saveUser(user);
	}

	public void removeUser(String id) {
		userRepository.removeUser(id);
	}

	public User getUser(String id) {
		return userRepository.getUser(id);
	}
}
