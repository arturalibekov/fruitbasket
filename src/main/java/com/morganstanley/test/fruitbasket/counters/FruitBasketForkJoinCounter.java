package com.morganstanley.test.fruitbasket.counters;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import com.morganstanley.test.fruitbasket.fruits.Fruit;
import com.morganstanley.test.fruitbasket.fruits.FruitBasket;

/**
 * Fork join counter
 * 
 * @author Artur
 *
 */
class FruitBasketForkJoinCounter implements FruitBasketCounter {

    private static final int MIN_UNIT_OF_WORK = 1000;

    /**
     * Count fruits using fork join
     * @param fruitBasket
     * @return counted cost
     */
    public double countFruitsCost(FruitBasket fruitBasket) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        List<Fruit> fruits = fruitBasket.getFruits();
        RecursiveTask<Double> task = new CountTaskFruit(fruits, 0, fruits.size()-1);
        Double result = forkJoinPool.invoke(task);
        return result.doubleValue();
    }
    
    
    
    /**
     * Recursive Task to count fruits cost
     * @author Artur
     *
     */
    private static class CountTaskFruit extends RecursiveTask<Double> {

        private static final long serialVersionUID = 1L;

        private final List<Fruit> fruits;
        private final int startIndex;
        private final int endIndex;

        CountTaskFruit(List<Fruit> fruits, int startIndex, int endIndex) {
            this.fruits = fruits;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            
        }
        
        
        @Override
        protected Double compute() {
            // is unit of work small to execute
            if (endIndex - startIndex < MIN_UNIT_OF_WORK) {
                return sumFruitCost();
            }
            
            // let's divide the work
            List<CountTaskFruit> tasks = new ArrayList<>(); 
            int mid = (endIndex - startIndex) >> 1;
            CountTaskFruit taskLeft = new CountTaskFruit(fruits, startIndex, mid);
            CountTaskFruit taskRight = new CountTaskFruit(fruits, mid + 1, endIndex);
            tasks.add(taskLeft);
            tasks.add(taskRight);
            
            // fork
            for(CountTaskFruit task : tasks) {
                task.fork();
            }
            
            // join
            double sum = 0;
            for(CountTaskFruit task : tasks) {
                sum += task.join().doubleValue();
            }
            return sum;
        }


        private double sumFruitCost() {
            double sum = 0.0;
            for(int j=startIndex; j<= endIndex; j++) {
                Fruit fruit = fruits.get(j);
                if (fruit != null && !Double.isNaN(fruit.getCost())) {
                    sum += fruit.getCost();
                }
            }
            return sum;
        }
        
    }
}
