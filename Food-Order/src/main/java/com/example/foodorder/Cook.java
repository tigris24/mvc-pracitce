package com.example.foodorder;

import java.util.Objects;

public class Cook {
	private final int price;
	private final String name;

	public Cook(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public Cook(MenuItem menuItem) {
		this.name = menuItem.getName();
		this.price = menuItem.getPrice();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Cook cook = (Cook)o;
		return price == cook.price && Objects.equals(name, cook.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(price, name);
	}
}
