package com.morganstanley.test.fruitbasket.fruits;

/**
 * Abstract Fruit
 * 
 * @author Artur
 *
 */
public class AbstractFruit implements Fruit {

	private final String fruitName;
	private final double price;

	protected AbstractFruit(String name, double price) {
		this.fruitName = name;
		this.price = price;
	}
	
	/**
	 * fruit price
	 */
	public double getCost() {
		return price;
	}


	/**
	 * fruit name
	 */
	public String getFruitName() {
		return fruitName;
	}

}
