package com.example.calculatorweb;


import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

public class QueryStringsTest {
	@Test
	void createTest(){
		QueryStrings queryStrings = new QueryStrings("operand1=11&operator=*&operand2=55");
		assertThat(queryStrings).isNotNull();
	}
}
