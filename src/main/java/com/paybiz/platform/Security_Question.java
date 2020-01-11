package com.paybiz.platform;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Document
@Setter
@Getter
@NoArgsConstructor
public class Security_Question {

	@JsonProperty("question")
	private String question;
	
	@JsonProperty("answer")
	private String answer;
}
