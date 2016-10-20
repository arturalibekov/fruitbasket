package com.morganstanley.test.fruitbasket.counters;

import com.morganstanley.test.fruitbasket.fruits.FruitBasket;

/**
 * FruitBasket counter
 * 
 * @author Artur
 */
interface FruitBasketCounter {

    /**
     * Counts cost if fruitBasket
     * @param fruitBasket
     * @return cost
     */
    public double countFruitsCost(FruitBasket fruitBasket);
}
