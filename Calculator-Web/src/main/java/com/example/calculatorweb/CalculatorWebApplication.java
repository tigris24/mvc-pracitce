package com.example.calculatorweb;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// GET /calculate?operand1=11&operator=*&operand2=55
@SpringBootApplication
public class CalculatorWebApplication {

	public static void main(String[] args) throws IOException {
		new CustomWebApplicationServer(8080).start();
	}

}
