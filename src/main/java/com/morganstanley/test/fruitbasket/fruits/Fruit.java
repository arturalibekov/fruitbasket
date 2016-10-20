package com.morganstanley.test.fruitbasket.fruits;


/**
 * Defines fruit interface
 * which includes Bananas, Oranges, Apples, Lemons, Peaches
 * 
 * @author Artur
 *
 */
public interface Fruit {

	
	/**
	 * The fruit name
	 * @return fruit name
	 */
	public String getFruitName();
	
	/**
	 * The fruit price
	 * @return fruit price
	 */
	public double getCost();
	
}
