package com.example.elementcalculator;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * 요구사항
 * 간단한 사칙연산을 할 수 있다.
 * 양수로만 계산할 수 있다.
 * 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
 * MVC 패턴(Model-View-Controller) 기반으로 구현한다.
 */
public class CalculatorTest {

	private static Stream<Arguments> formulaAndResult() {
		return Stream.of(
			arguments(new PositiveNumber(1), "+", new PositiveNumber(2), 3),
			arguments(new PositiveNumber(1), "-", new PositiveNumber(2), -1),
			arguments(new PositiveNumber(4), "*", new PositiveNumber(2), 8),
			arguments(new PositiveNumber(4), "/", new PositiveNumber(2), 2)
		);
	}

	@DisplayName("덧셈 연산을 수행한다.")
	@ParameterizedTest
	@MethodSource("formulaAndResult")
	void calculateTest(PositiveNumber operand1, String operand, PositiveNumber operand2, int result) {

		int calculateResult = Calculator.calculate(operand1.toInt(), operand, operand2.toInt());
		assertThat(calculateResult).isEqualTo(result);
	}

	/*@DisplayName("나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.")
	@Test
	void calculateExceptionTest() {
		*//**
		 * assertThatCode : 예외가 발생하면 실패, 에러가 발생하면 안되는 상황 테스트
		 * 					"예외가 발생할 수도, 아닐 수도"
		 * 					주어진 코드 블록이 예외를 던지지 않는지 또는 던질 때 특정 예외를 던지는지 확인
		 * assertThatThrownBy : 예외가 발생하면 성공, 에러가 발생해야 하는 상황 테스트
		 * 						"예외가 발생할 것으로 기대되는"
		 * 						주어진 코드 블록이 특정 예외를 던지는지, 그리고 그 예외가 기대한 조건을 만족하는지를 더욱 명확하게 테스트
		 *//*
		assertThatCode(() -> Calculator.calculate(new PositiveNumber(10), "/", new PositiveNumber(2)))
			.doesNotThrowAnyException();
		assertThatCode(() -> Calculator.calculate(new PositiveNumber(10), "/", new PositiveNumber(0)))
			.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> Calculator.calculate(new PositiveNumber(10), "/", new PositiveNumber(0)))
			.isInstanceOf(IllegalArgumentException.class);

	}*/


	/*@DisplayName("뺄셈 연산을 수행한다.")
	@Test
	void subtractionTest() {

		int result = Calculator.calculate(1, "-", 2);
		assertThat(result).isEqualTo(-1);
	}
	*/

}
