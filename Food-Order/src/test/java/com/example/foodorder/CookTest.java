package com.example.foodorder;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CookTest {

	@DisplayName("요리를 생성한다.")
	@Test
	void createTest(){
		assertThatCode(() -> new Cook("만두", 5000))
			.doesNotThrowAnyException();
	}
}
