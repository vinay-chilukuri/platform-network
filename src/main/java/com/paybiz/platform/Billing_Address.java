package com.paybiz.platform;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document
@Setter
@Getter
@NoArgsConstructor
public class Billing_Address {
	
	@JsonProperty("address_line1")
	private String address_line1;
	
	@JsonProperty("address_line2")
	private String address_line2;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("postal_code")
	private String postal_code;	

}
