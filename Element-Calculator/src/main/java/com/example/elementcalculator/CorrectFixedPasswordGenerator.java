package com.example.elementcalculator;

public class CorrectFixedPasswordGenerator implements PasswordGenerator{
	@Override
	public String generatePassword() {
		return "abcdefgh";
	}

}
