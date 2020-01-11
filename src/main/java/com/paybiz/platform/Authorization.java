package com.paybiz.platform;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class Authorization {
	
	@GetMapping(path="/get")
	public static JSONObject getToken() { 
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		Map<String,String> map = new HashMap<String, String>();
		
		System.out.println("hello");
		
		map.put("client_id","Z9RVh4ccAu1VRAEGjGBSIdLOyk58t4pb");
	    map.put("client_secret", "zdNPf8X-op45p1Z-_iOUWf6O0qIkptrSFCEG8kthlKgK7Qq1-cp5_lQSObZL-vq1");
	    map.put("audience", "https://sentiment-analysis.io");
	    map.put("grant_type","client_credentials");
		
	    HttpEntity<Map<String, String>> request = new HttpEntity<>(map, headers);
	    RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "https://dev-9qlbupn3.auth0.com/oauth/token";
//		ParameterizedTypeReference<Map<String, String>> typeRef = new ParameterizedTypeReference<Map<String, String>>() {};

		ResponseEntity<JSONObject> response = restTemplate.postForEntity(fooResourceUrl, request,JSONObject.class);
		System.out.println(response.getBody());
		return response.getBody();
		
	}
}
