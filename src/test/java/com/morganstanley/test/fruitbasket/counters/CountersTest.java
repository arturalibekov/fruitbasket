package com.morganstanley.test.fruitbasket.counters;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Test;

import com.morganstanley.test.fruitbasket.TestsHelper;
import com.morganstanley.test.fruitbasket.fruits.Fruit;
import com.morganstanley.test.fruitbasket.fruits.FruitBasket;

public class CountersTest {

    @Test
    public void testCountFruitsCost$EmptyBasket() {
        FruitBasket basket = new FruitBasket(Collections.<Fruit>emptyList());
        double cost = Counters.countFruitsCost(basket);
        assertEquals("Must be 0", .0, cost, 0.00000001);
    }
    
    
    @Test
    public void testCountFruitsCost() {
        FruitBasket basket = TestsHelper.createDefaultFruitBasket();
        double cost = Counters.countFruitsCost(basket);
        assertEquals("Must be 89", 89.0, cost, 0.00000001);
    }

}
