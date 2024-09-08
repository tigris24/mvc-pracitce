package com.example.elementcalculator;

public class WrongFixedPasswordGenerator implements PasswordGenerator {
	@Override
	public String generatePassword() {
		return "ab";
	}
}
