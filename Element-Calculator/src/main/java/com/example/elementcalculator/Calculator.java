package com.example.elementcalculator;

import java.util.List;

import com.example.elementcalculator.calculator.AdditionOperator;
import com.example.elementcalculator.calculator.DivisionOperator;
import com.example.elementcalculator.calculator.MultiplicationOperator;
import com.example.elementcalculator.calculator.SubtractionOperator;

public class Calculator {
	private static final List<NewArithmeticOperator> arithmeticOperands
		= List.of(
		new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator()
	);

	public static int calculate(int operator1, String operand, int operator2) {
		return arithmeticOperands.stream()
			.filter(arithmeticOperands -> arithmeticOperands.supports(operand))
			.map(arithmeticOperator -> arithmeticOperator.calculate(operator1, operator2))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("올바른 사칙 연산이 아닙니다."));

		// return ArithmeticOperator.calculate(operator1, operand, operator2);

		/*if ("+".equals(operand)) {
			return operator1 + operator2;
		} else if ("-".equals(operand)) {
			return operator1 - operator2;
		} else if ("*".equals(operand)) {
			return operator1 * operator2;
		} else if ("/".equals(operand)) {
			return (double)operator1 / operator2;
		}

		return 0;*/

	}
}
