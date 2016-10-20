package com.morganstanley.test.fruitbasket;

import java.io.StringReader;

import com.morganstanley.test.fruitbasket.fruits.FruitBasket;

/**
 * Helper class
 * @author Artur
 *
 */
public abstract class TestsHelper {

    private TestsHelper() {     
    }
    
    /**
     * Default method for creating fruit basket
     * @return fruit basket
     */
    public static FruitBasket createDefaultFruitBasket() {
        StringReader reader = new StringReader(String.format(
                "Apple, 10 %n Orange, 21 %n Banana, 45 %n Lemon, 6 %n Peach, 7", ""));
        return FruitFactory.createFruitBasket(reader);
    }
    
}
