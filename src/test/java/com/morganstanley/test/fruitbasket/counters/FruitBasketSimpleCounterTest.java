package com.morganstanley.test.fruitbasket.counters;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import java.util.ArrayList;

import org.junit.Test;

import com.morganstanley.test.fruitbasket.FruitFactory;
import com.morganstanley.test.fruitbasket.fruits.Fruit;
import com.morganstanley.test.fruitbasket.fruits.FruitBasket;

public class FruitBasketSimpleCounterTest {

    @Test
    public void testCountFruits$EmptyBasket() {
        ArrayList<Fruit> fruits = new ArrayList<>();
        FruitBasket fruitBasket = new FruitBasket(fruits);
        double result = new FruitBasketSimpleCounter().countFruitsCost(fruitBasket);
        assertEquals("Must be zero", 0.0, result, 0.000000001);
    }
    
    
    @Test
    public void testCountFruits() {
        StringReader reader = new StringReader(String.format(
                "Apple, 10 %n Orange, 21 %n Banana, 45 %n Lemon, 6 %n Peach, 7", ""));
        FruitBasket basket = FruitFactory.createFruitBasket(reader);
        double result = new FruitBasketSimpleCounter().countFruitsCost(basket);
        assertEquals("Must be 89", 89, result, 0.000000001);
    }

}
