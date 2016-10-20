package com.morganstanley.test.fruitbasket;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import com.morganstanley.test.fruitbasket.counters.Counters;
import com.morganstanley.test.fruitbasket.fruits.Fruit;
import com.morganstanley.test.fruitbasket.fruits.FruitBasket;

/**
 * Bootstrap class
 * 
 * @author Artur
 *
 */
public class BootStrap {

    /**
     * Starts boot strap
     * @param args
     */
    public static void main(String[] args) {
        try (InputStream source = getFruitBasketSource(args)) {
            if (source == null) {
                printHelp();
                return;
            }
            countFruitCostAndPrintIt(source);
        } catch (Exception e) {
            System.out.println(String.format("Failed to read and count fruits in the basket. %n %s", e.getMessage()));
            printHelp();
        }
    }

    /**
     * Counts fruit cost
     * @param source
     */
    private static void countFruitCostAndPrintIt(InputStream source) {
        Reader reader = new InputStreamReader(source);
        FruitBasket fruitBasket = FruitFactory.createFruitBasket(reader);
        double cost = Counters.countFruitsCost(fruitBasket);
        List<Fruit> fruits = fruitBasket.getFruits();
        System.out.println(String.format("Basket contained %s fruit(s) with overall cost %.5f %n", fruits.size(), cost));
    }

    /**
     * Looks for source fruits provider
     * @param args
     * @throws Exception when provider cann't be properly managed
     * @return InputStream
     */
    private static InputStream getFruitBasketSource(String[] args) throws Exception {
        if (args.length == 1) {
            File file = new File(args[0]);
            if (file.exists() && file.canRead()) {
                return new FileInputStream(file);
            }
        }
        // is piping enabled
        return null;
    }
    
    /**
     * Prints help
     */
    private static final void printHelp() {
        System.out.println(String.format("Please provide a properly formated file to read fruit basket.%n"
                + "Eeach line in the file must represent: %n  FruitName, Price %n", ""));
    }

}
