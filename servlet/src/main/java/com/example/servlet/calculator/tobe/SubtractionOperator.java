package com.example.servlet.calculator.tobe;

import com.example.servlet.calculator.domain.PositiveNumber;

public class SubtractionOperator implements ArithmeticOperator {
    @Override
    public boolean supports(String operator) {
        return "-".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        return operand1.toInt() - operand2.toInt();
    }
}
