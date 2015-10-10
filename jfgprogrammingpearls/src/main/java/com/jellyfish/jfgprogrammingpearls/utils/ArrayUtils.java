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

}
