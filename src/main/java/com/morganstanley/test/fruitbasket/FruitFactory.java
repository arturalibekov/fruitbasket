package com.morganstanley.test.fruitbasket;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.morganstanley.test.fruitbasket.fruits.AbstractFruit;
import com.morganstanley.test.fruitbasket.fruits.Fruit;
import com.morganstanley.test.fruitbasket.fruits.FruitBasket;

/**
 * Fruit Factory
 * 
 * @author Artur
 *
 */
public abstract class FruitFactory {

    public static final Set<String> KNOWN_FRUITS = new HashSet<String>(
            Arrays.asList(new String[] { "APPLE", "ORANGE", "BANANA", "LEMON", "PEACH" }));

    /**
     * Creates Fruit with a price from a string description: FruitName, price
     * 
     * 
     * @param description
     * @throws IllegalArgumentException
     *             if unknown format for fruit description is provided
     * @return Fruit
     */
    public static Fruit createFruit(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("No description is provided");
        }
        String[] nameAndPrice = description.split(",");
        if (nameAndPrice.length != 2) {
            throw new IllegalArgumentException("Description must be in fomat : FruitName, Price");
        }
        String fruitName = nameAndPrice[0].trim();
        String priceStr = nameAndPrice[1].trim();
        if (!KNOWN_FRUITS.contains(fruitName.toUpperCase())) {
            throw new IllegalArgumentException(
                    String.format("Unknown fruit name : %s. The basket can contain only %s", fruitName, KNOWN_FRUITS));
        }
        double price;
        try {
            price = Double.parseDouble(priceStr);
            if (price < 0.0) {
                throw new IllegalArgumentException("Price must be greate than 0.0; but was " + priceStr);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Unknow format for the price " + priceStr);
        }
        return new AbstractFruit(fruitName, price) {
        };
    }

    /**
     * Creates FruitBasket from input stream
     * 
     * @param reader
     * @throws IllegalArgumentException
     * @return FruitBasket
     */
    public static FruitBasket createFruitBasket(Reader reader) {
        try (Scanner scanner = new Scanner(reader)) {
            String fruitDescription;
            List<Fruit> fruits = new ArrayList<>();
            while (scanner.hasNextLine()) {
                fruitDescription = scanner.nextLine();
                if (fruitDescription.trim().isEmpty()) {
                    break;
                }
                Fruit fruit = createFruit(fruitDescription);
                fruits.add(fruit);
            }
            return new FruitBasket(fruits);
        }
    }

}
