package com.example.foodorder;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CookingTest {

	@DisplayName("메뉴에 해당하는 음식을 만든다.")
	@Test
	void makeCookTest(){
		Cooking cooking = new Cooking();
		MenuItem menuItem = new MenuItem("돈까스", 5000);
		Cook cook = cooking.makeCook(menuItem);
		// 객체들 간의 비교를 하려면 객체 클래스에 equals, hashcode 가 Override 되어 있어야 한다.
		assertThat(cook).isEqualTo(new Cook("돈까스", 5000));
	}
}
