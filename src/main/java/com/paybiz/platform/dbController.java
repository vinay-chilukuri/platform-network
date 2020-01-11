package com.paybiz.platform;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/db")
public class dbController {
	
	@Autowired
	UserDao dao;

	@Autowired
	MongoOperations mongoOperation;
	
	
	@GetMapping(path="/delete")
	public String delete(){
		
		dao.deleteAll();
		
		return "Success";
		
	} 
	
	@PostMapping(path="/add")
	public String add(@RequestBody User user){
		
		dao.insert(user);
	
		return "Success";		
	} 
	
	@GetMapping(path="/getall")
	public List<User> get(){
		return dao.findAll();
	
	}
	
	@GetMapping(path="/getone")
	public User getone(@RequestParam String username ){
		return dao.findByUsername(username);
	
	}


}
