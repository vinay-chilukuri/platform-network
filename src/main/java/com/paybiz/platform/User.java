package com.paybiz.platform;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "data")
@Getter
@Setter
@NoArgsConstructor
public class User {

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Payment_Method> getPayment_methods() {
		return payment_methods;
	}

	public void setPayment_methods(List<Payment_Method> payment_methods) {
		this.payment_methods = payment_methods;
	}

	public String getActivated() {
		return activated;
	}

	public void setActivated(String activated) {
		this.activated = activated;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public List<Security_Question> getSecurity_question() {
		return security_question;
	}

	public void setSecurity_question(List<Security_Question> security_question) {
		this.security_question = security_question;
	}

	public List<Billing_Address> getBilling_address() {
		return billing_address;
	}

	public void setBilling_address(List<Billing_Address> billing_address) {
		this.billing_address = billing_address;
	}

	public String getLast_login() {
		return last_login;
	}

	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@JsonProperty("_id")
	@Id
	private String id;
	
	@JsonProperty("username")
	private String username;
	
	@JsonProperty("full_name")
	private String full_name;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("phone")
	private String phone;
	
	@JsonProperty("payment_methods")
	private List<Payment_Method> payment_methods;
	
	@JsonProperty("activated")
	private String activated;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("nationality")
	private String nationality;
	
	@JsonProperty("security_question")
	private List<Security_Question> security_question;
	
	@JsonProperty("billing_address")
	private List<Billing_Address> billing_address;
	
	@JsonProperty("last_login")
	private String last_login;
	
	@JsonProperty("role")
	private String role;
	
	
	
	
	
}
