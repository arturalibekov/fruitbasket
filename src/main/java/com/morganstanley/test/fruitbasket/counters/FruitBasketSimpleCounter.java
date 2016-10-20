package com.morganstanley.test.fruitbasket.counters;

import java.util.List;

import com.morganstanley.test.fruitbasket.fruits.Fruit;
import com.morganstanley.test.fruitbasket.fruits.FruitBasket;

/**
 * Simple counter
 * 
 * @author Artur
 *
 */
class FruitBasketSimpleCounter implements FruitBasketCounter {
	
	/**
	 * Simple counter
	 * @return basket cost
	 */
	public double countFruitsCost(FruitBasket fruitBasket) {
		List<Fruit> fruits = fruitBasket.getFruits();
		double fullPrice = 0.0;
		for(int j=0; j < fruits.size(); j++) {
			Fruit fruit = fruits.get(j);
			if (fruit != null && !Double.isNaN(fruit.getCost())) {
		        fullPrice += fruit.getCost(); 
			}
		}
		return fullPrice;
	}
}
