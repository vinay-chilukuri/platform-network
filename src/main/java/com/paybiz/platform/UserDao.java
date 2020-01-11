package com.paybiz.platform;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserDao extends MongoRepository<User, String> {
	
	public User findByUsername(String username);
	public User deleteByUsername(String username);
	

}
