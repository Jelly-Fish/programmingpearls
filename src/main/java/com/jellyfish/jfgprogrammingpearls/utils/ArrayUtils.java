package com.jellyfish.jfgprogrammingpearls.utils;

import com.jellyfish.jfgprogrammingpearls.exceptions.SubArrayNotFoundException;
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
    
    /**
     * Return max integer value from param array.
     * @param iMax Integer array.
     * @return max integer value from param array.
     */
    public static int max(Integer ... iMax) {
        int max = Integer.MIN_VALUE;
        for (Integer i : iMax) {
            max = i > max ? i : max; 
        }
        return max;
    }

    /**
     * @param v the array to sum up.
     * @return sum of all entries in the array.
     */
    public static int arraySum(int[] v) {
        int result = 0;
        for (int i = 0; i < v.length; i++) result += v[i];
        return result;
    }
    
    /**
     * sum of all entries in the array.
     * @param v the array to sum up.
     * @param a start index.
     * @param b stop index.
     * @return 
     */
    public static int subArraySum(int[] v, final int a, final int b) {
        int result = 0;
        for (int i = a; i < b + 1; i++) result += v[i];
        return result;
    }

    /**
     * @param maxSum
     * @param v main array.
     * @param u end index.
     * @return the max summed up sub array as an array of integers that contains a copy of
     * the sub vector.array
     * @throws com.jellyfish.jfgprogrammingpearls.exceptions.SubArrayNotFoundException
     */
    public static int[] getSubArray(final int maxSum, int[] v, final int u) throws SubArrayNotFoundException {
        // N^2 complexity.
        for (int i = u; i > 0; i--) {
            for (int j = u; j > 0; j--) {
                if (ArrayUtils.subArraySum(v, j, i) == maxSum) 
                    return java.util.Arrays.copyOfRange(v, j, i + 1);
            }
        }
        throw new SubArrayNotFoundException();
    }

}
