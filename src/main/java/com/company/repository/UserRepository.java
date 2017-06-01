package com.company.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.company.domain.User;

@Repository
public class UserRepository {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<User> getUsers() {
		return mongoTemplate.findAll(User.class);
	}

	public void saveUser(User user) {
		mongoTemplate.save(user);
	}

	public void removeUser(String id) {
		mongoTemplate.remove(new Query(Criteria.where("id").is(id)), User.class);
	}

	public User getUser(String id) {
		return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)), User.class);
	}

}
