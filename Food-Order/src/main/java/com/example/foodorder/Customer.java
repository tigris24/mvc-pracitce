package com.example.foodorder;

public class Customer {
	public Cook order(String manuName, Menu menu, Cooking cooking){
		MenuItem menuItem = menu.choose(manuName);
		Cook cook = cooking.makeCook(menuItem);
		return cook;
	}
}
