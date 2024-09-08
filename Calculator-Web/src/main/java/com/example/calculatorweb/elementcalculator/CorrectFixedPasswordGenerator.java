package com.example.calculatorweb.elementcalculator;

public class CorrectFixedPasswordGenerator implements PasswordGenerator{
	@Override
	public String generatePassword() {
		return "abcdefgh";
	}

}
