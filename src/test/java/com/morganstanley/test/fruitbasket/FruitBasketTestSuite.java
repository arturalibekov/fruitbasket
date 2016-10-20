package com.morganstanley.test.fruitbasket;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.morganstanley.test.fruitbasket.counters.CountersTest;
import com.morganstanley.test.fruitbasket.counters.FruitBasketForkJoinCounterTest;
import com.morganstanley.test.fruitbasket.counters.FruitBasketSimpleCounterTest;

/**
 * Test suite
 * 
 * @author Artur
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ 
    FruitFactoryTest.class,
    FruitBasketSimpleCounterTest.class,
    FruitBasketForkJoinCounterTest.class,
    FruitBasketSimpleCounterTest.class,
    CountersTest.class
})
public class FruitBasketTestSuite {

}
