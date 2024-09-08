package com.example.calculatorweb;



import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

public class QueryStringTest {
	@Test
	void createTest(){
		QueryString queryString = new QueryString("operand1=","11");
		assertThat(queryString).isNotNull();
	}
}
