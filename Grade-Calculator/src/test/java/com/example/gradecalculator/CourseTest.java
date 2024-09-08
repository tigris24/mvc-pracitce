package com.example.gradecalculator;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CourseTest {

	@DisplayName("과목(코스)를 생성한다.")
	@Test
	void createTest() {
		assertThatCode(() -> new Course("OOP", 3, "A+"))
			.doesNotThrowAnyException();
	}

}
