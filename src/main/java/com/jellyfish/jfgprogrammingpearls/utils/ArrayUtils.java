package com.jellyfish.jfgprogrammingpearls.utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author thw
 */
public class ArrayUtils {

    /**
     * Implementing Fisher–Yates shuffle
     * @param integerArray the array to shuffle.
     */
    public static void shuffleArray(int[] integerArray) {

        final Random rand = ThreadLocalRandom.current();
        for (int i = integerArray.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            // Simple swap
            int a = integerArray[index];
            integerArray[index] = integerArray[i];
            integerArray[i] = a;
        }
    }
    
    /**
     * @param size The maximum array lenght for affecting rand integers.
     * @return 
     */
    public static int[] randomIntegers(final int size) {
        
        final Random rand = new Random();
        final int[] integers = new int[size];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = (rand.nextInt(65536) - 32768);
        }
        return integers;
    }

}
