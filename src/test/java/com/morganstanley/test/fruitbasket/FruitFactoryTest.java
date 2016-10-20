package com.morganstanley.test.fruitbasket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.StringReader;
import java.util.List;

import org.junit.Test;

import com.morganstanley.test.fruitbasket.fruits.Fruit;
import com.morganstanley.test.fruitbasket.fruits.FruitBasket;

public class FruitFactoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCreateFruit$Empty() {
        FruitFactory.createFruit("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCreateFruit$Null() {
        FruitFactory.createFruit(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCreateFruit$UnknownFormat() {
        FruitFactory.createFruit("Apple");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCreateFruit$NegativeFormat() {
        FruitFactory.createFruit("Apple, -1");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCreateFruit$UnknonwFruit() {
        FruitFactory.createFruit("Plum, 1.12");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCreateFruit$NotParsablePrice() {
        FruitFactory.createFruit("Plum, 12ddf");
    }

    @Test
    public void testCreateFruit() {
        Fruit fruit = FruitFactory.createFruit("Apple, 12.145");
        assertNotNull("Fruit must be created", fruit);
        assertEquals("Must be APPLE", "APPLE", fruit.getFruitName().toUpperCase());
        assertEquals("Must be equal to 12.145", 12.145, fruit.getCost(), 0.00001);
        
        fruit = FruitFactory.createFruit("Peach, 1");
        assertNotNull("Fruit must be created", fruit);
        assertEquals("Must be Peach", "PEACH", fruit.getFruitName().toUpperCase());
        assertEquals("Must be equal to 1", 1, fruit.getCost(), 0.00001);
        
        
        fruit = FruitFactory.createFruit("Orange,0.0009");
        assertNotNull("Fruit must be created", fruit);
        assertEquals("Must be Peach", "ORANGE", fruit.getFruitName().toUpperCase());
        assertEquals("Must be equal to 0.0009", 0.0009, fruit.getCost(), 0.00001);

        fruit = FruitFactory.createFruit("Banana, 1234567890");
        assertNotNull("Fruit must be created", fruit);
        assertEquals("Must be Peach", "BANANA", fruit.getFruitName().toUpperCase());
        assertEquals("Must be equal to 0.0009", 1234567890.0, fruit.getCost(), 0.00001);

        
        fruit = FruitFactory.createFruit("Lemon, 0");
        assertNotNull("Fruit must be created", fruit);
        assertEquals("Must be Peach", "LEMON", fruit.getFruitName().toUpperCase());
        assertEquals("Must be equal to 0.0",  0.0, fruit.getCost(), 0.00001);
    
    }

    @Test
    public void testCreateFruitBasket() {
        StringReader reader = new StringReader(String.format(
                "Apple, 10 %n Orange, 21 %n Banana, 45 %n Lemon, 6 %n Peach, 7", ""));
        FruitBasket basket = FruitFactory.createFruitBasket(reader);
        List<Fruit> fruits = basket.getFruits();
        assertEquals("Num of fruits expected",  5,  fruits.size());
    }
    
    
    @Test
    public void testCreateFruitBasket$EmptyBasket() {
        StringReader reader = new StringReader("");
        FruitBasket basket = FruitFactory.createFruitBasket(reader);
        List<Fruit> fruits = basket.getFruits();
        assertEquals("Num of fruits expected",  0,  fruits.size());
    }

}
