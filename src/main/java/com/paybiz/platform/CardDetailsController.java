package com.paybiz.platform;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/cardDetails")
public class CardDetailsController {

	@Autowired
	UserDao dao;
	
	
	@Autowired
	MongoOperations mongoOperation;
	
	@GetMapping(path="/get")
	public ResponseEntity<List<Payment_Method>> getCardDetails(@RequestParam String username){
		
		User user=dao.findByUsername(username);
		if (user == null) {
			return ResponseEntity.status(409).body(null);
		}
		return ResponseEntity.status(200).body(user.getPayment_methods());
		
	}
	
	@PostMapping(path="/addCard",produces="application/json",consumes="application/json")
	public ResponseEntity<String> addCardDetails(@RequestParam String username,@RequestBody Map<String,String> payload){
		
		
		String name=payload.get("name");
		
		String cardnumber=payload.get("cardnumber");
		String expiryDate=payload.get("expiryDate");
		String nick=payload.get("nick");
		String lasttransaction=payload.get("lasttransaction");
		String icon=payload.get("icon");		
		
		
		
		Payment_Method payment_method =new Payment_Method();
		
		payment_method.setCardnumber(cardnumber);
		
		payment_method.setExpiryDate(expiryDate);
		
		payment_method.setName(name);
		payment_method.setIcon(icon);
		payment_method.setNick(nick);
		payment_method.setLasttransaction(lasttransaction);
		
		User user =dao.findByUsername(username);
		List<Payment_Method> payment_methods=user.getPayment_methods();
		payment_methods.add(payment_method);
		
		dao.save(user);
		
		return ResponseEntity.status(200).body("Success");
		
	}
	
	
	
	
}

