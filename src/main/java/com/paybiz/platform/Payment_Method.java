package com.paybiz.platform;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@Setter
@Getter
public class Payment_Method {
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}


	@JsonProperty("icon")
	private String icon;
	
	
	@JsonProperty("lasttransaction")
	private String lasttransaction;

	@JsonProperty("name")
	private String name;
	

	
	@JsonProperty("cardnumber")
	private String cardnumber;
	
	@JsonProperty("expiryDate")
	private String expiryDate;
	
	@JsonProperty("nick")
	private String nick;
	
	
	
	
}
