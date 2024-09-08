package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.servlet.calculator.domain.Calculator;
import com.example.servlet.calculator.domain.PositiveNumber;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet /*GenericServlet*/ {
	private static final Logger log = LoggerFactory.getLogger(CalculatorServlet.class);

	// private ServletConfig servletConfig;
	//
	// @Override
	// public void init(ServletConfig config) throws ServletException {
	// 	log.info("init");
	// 	this.servletConfig = config;
	// }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		log.info("service");
		int operand1 = Integer.parseInt(request.getParameter("operand1"));
		String operator = request.getParameter("operator");
		int operand2 = Integer.parseInt(request.getParameter("operand2"));

		int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

		PrintWriter writer = response.getWriter();
		writer.println(result);
	}
	//
	// @Override
	// public void destroy() {
	//
	// }
	//
	// @Override
	// public ServletConfig getServletConfig() {
	// 	return this.servletConfig;
	// }
	//
	// @Override
	// public String getServletInfo() {
	// 	return null;
	// }
}
