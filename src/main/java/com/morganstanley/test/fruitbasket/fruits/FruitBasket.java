package com.morganstanley.test.fruitbasket.fruits;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Fruit Basket
 * 
 * @author Artur
 *
 */
public class FruitBasket {

	// basket of fruits
	private final List<Fruit> fruits = new ArrayList<Fruit>();

	/**
	 * Creates fruit basket
	 * @param fruits
	 */
	public FruitBasket(Collection<? extends Fruit> fruits) {
		if (fruits != null) {
			this.fruits.addAll(fruits);
		}
	}
	
	/**
	 * @return fruits in the basket
	 */
	public List<Fruit> getFruits() {
		return Collections.unmodifiableList(fruits);
	}
	
}
