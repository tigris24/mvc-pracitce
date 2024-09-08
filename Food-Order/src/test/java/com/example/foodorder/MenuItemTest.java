package com.example.foodorder;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuItemTest {

	@DisplayName("메뉴 항목을 생성한다.")
	@Test
	void test() {
		assertThatCode(() -> new MenuItem("만두", 5000))
			.doesNotThrowAnyException();
	}

}
