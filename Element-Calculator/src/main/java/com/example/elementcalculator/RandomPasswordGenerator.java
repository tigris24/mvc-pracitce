package com.example.elementcalculator;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

public class RandomPasswordGenerator implements com.example.elementcalculator.PasswordGenerator {
	/**
	 * Special characters allowed in password.
	 */

	public static final String ALLOWED_SPL_CHARACTERS = "!@#$%^&*()_+";
	public static final String ERROR_CODE = "ERRORNEOUS_SPECIAL_CHARS";

	public String generatePassword() {
		PasswordGenerator gen = new PasswordGenerator();

		CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
		CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
		lowerCaseRule.setNumberOfCharacters(2);

		CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
		CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
		upperCaseRule.setNumberOfCharacters(2);

		CharacterData digitChars = EnglishCharacterData.Digit;
		CharacterRule digitRule = new CharacterRule(digitChars);
		digitRule.setNumberOfCharacters(2);

		CharacterData specialChars = new CharacterData() {
			public String getErrorCode() {
				return ERROR_CODE;
			}

			public String getCharacters() {
				return ALLOWED_SPL_CHARACTERS;
			}
		};
		CharacterRule sqlCharRule = new CharacterRule(specialChars);
		sqlCharRule.setNumberOfCharacters(2);

		return gen.generatePassword((int)(Math.random() * 13), sqlCharRule, lowerCaseRule, upperCaseRule, digitRule);

	}
}
