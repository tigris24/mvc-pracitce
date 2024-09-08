package com.example.elementcalculator;

public class User {
	private String password;

	public void initPassword(PasswordGenerator passwordGenerator){
		// RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
		String password = passwordGenerator.generatePassword();

		/**
		 * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
		 */
		int length = password.length();

		if(length >= 8 && length <= 12){
			this.password = password;
		}
	}

	public String getPassword() {
		return password;
	}
}
