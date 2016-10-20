package com.morganstanley.test.fruitbasket.counters;

import com.morganstanley.test.fruitbasket.fruits.FruitBasket;

/**
 * Counters
 * @author Artur
 */
public class Counters {

    private static final int MAX_BASKET_SIZE_TO_START_FORKJOIN = 100000;

    /**
     * Counts fruit cost
     * @param fruitBasket
     * @return fruit cost
     */
    public static double countFruitsCost(FruitBasket fruitBasket) {
        if (fruitBasket == null || fruitBasket.getFruits().isEmpty()) {
            return 0.0;
        }
        FruitBasketCounter counter = obtainFruitCounter(fruitBasket);
        return counter.countFruitsCost(fruitBasket);
    }

    /**
     * Chooses proper counter for fruit basket
     * @param fruitBasket
     * @return FruitBasketCounter
     */
    private static FruitBasketCounter obtainFruitCounter(FruitBasket fruitBasket) {
        if (fruitBasket.getFruits().size() > MAX_BASKET_SIZE_TO_START_FORKJOIN) {
            return new FruitBasketForkJoinCounter();
        }
        return new FruitBasketSimpleCounter();
    }
    
}
