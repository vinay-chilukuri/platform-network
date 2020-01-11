package com.paybiz.platform;

import java.io.IOException;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.jpos.iso.ISODate;
import org.jpos.iso.ISOException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
@RequestMapping("/api/PaymentDetails")

public class AcquiringBankController {

	@CrossOrigin
	@PostMapping(path="/test1")
	public String  getMyCardDetails(@RequestBody Map<String,String> payload){
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("iso", iso);

		HttpEntity<Map<String, String>> request = new HttpEntity<>(payload, headers);

		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://35.202.73.251/api/acquiringbank/sendDetails";
		ResponseEntity<String> response = restTemplate.postForEntity(fooResourceUrl, request, String.class);

		return response.getBody();		
	}
	
	
	@GetMapping(path="/dummy")
	public String dummy() {
		
		
		return "Success";
	}
	
}
