package com.example.elementcalculator;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PositiveNumberTest {
	@ParameterizedTest
	@ValueSource(ints = {0, -1})
	void createTest(int value) {
		assertThatCode(() -> new PositiveNumber(value))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("0 또는 음수를 전달할 수 없습니다.");
	}
}
