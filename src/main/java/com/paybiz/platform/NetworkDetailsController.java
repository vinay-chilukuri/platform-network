package com.paybiz.platform;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Pow;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/networkDetails")
public class NetworkDetailsController {

	@PostMapping(path = "/checkNumber", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, String>> checkCard(@RequestBody Map<String, String> payload) {

		String cardNumber = payload.get("cardNumber");

		Map<String, String> response = new HashMap<>();

		if (!checkLuhn(cardNumber)) {
			response.put("Status", "Invalid Card Number");
			return ResponseEntity.status(409).body(response);
		}

		else {
			String cardType = findCardType(cardNumber);
			if (cardType == "VISA" && cardNumber.length() != 13 && cardNumber.length() != 16) {
				response.put("Status", "Invalid Card Number");
				return ResponseEntity.status(409).body(response);
			}

			if (cardType == "MASTERCARD" && cardNumber.length() != 16) {
				response.put("Status", "Invalid Card Number");
				return ResponseEntity.status(409).body(response);
			}

			if (cardType == "AmericanExpress" && cardNumber.length() != 15) {
				response.put("Status", "Invalid Card Number");
				return ResponseEntity.status(409).body(response);
			}
			if (cardType == "DiscoverCard" && cardNumber.length()!= 16) {
				response.put("Status", "Invalid Card Number");
				return ResponseEntity.status(409).body(response);
			}

			response.put("Status", "Valid card Number");
			response.put("CardType", cardType);
			return ResponseEntity.status(200).body(response);
		}

	}

	static boolean checkLuhn(String cardNo) {
		int nDigits = cardNo.length();

		int sum = 0;

		for (int i = 0; i < nDigits; i++) {
			if (i % 2 == 0)
				sum += (cardNo.charAt(nDigits - 1 - i) - '0');
			else {
				int num = (cardNo.charAt(nDigits - 1 - i) - '0') * 2;
				if (num > 9)
					sum += (num / 10 + num % 10);
				else
					sum += num;
			}
		}

		return (sum % 10 == 0);
	}

	static String findCardType(String cardNumber) {

		long IIN = 0;
		int nDigits = cardNumber.length();
		for (int i = 0; i < 6; i++) {
			IIN += (cardNumber.charAt(5 - i) - '0') * (Math.pow(10, i));
		}

		if (IIN / 100000 == 4)
			return "VISA";

		if ((IIN / 10000 >= 51 && IIN / 10000 <= 55) || (IIN / 100 >= 2221 && IIN / 100 <= 2720))
			return "MASTERCARD";

		if (IIN / 10000 == 34 || IIN / 10000 == 37)
			return "AmericanExpress";

		if (IIN / 100 == 6011 || (IIN >= 622126 && IIN <= 622925) || (IIN >= 624000 && IIN <= 626999)
				|| (IIN >= 628200 && IIN <= 628899) || IIN / 10000 == 64 || IIN / 10000 == 65)
			return "DiscoverCard";

		return "NOT Identified";
	}

}
