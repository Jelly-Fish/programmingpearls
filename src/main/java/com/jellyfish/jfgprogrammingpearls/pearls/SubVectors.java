package com.jellyfish.jfgprogrammingpearls.pearls;

/**
 *
 * @author thw
 */
public class SubVectors {
    
    /**
     * The main vector.
     */
    private final int[] vector;
    
    /**
     * Maximum entry sum Sub vector of vector.
     * Length = 0 if all entries of vector are smaller or equal to ZERO.
     */
    private int[] maxSumSubVector;

    /**
     * Constructor.
     * @param vector 
     */
    public SubVectors(final int[] vector) {
        this.vector = vector;
    }
    
    /**
     * 8.3 of Programming Pearls.
     */
    public void runDivideAndConquer() {
        display(divideAndConquer(0, this.vector.length - 1, this.vector), 
                String.valueOf(this.vector.length),
                "divideAndConquer(final int l, final int u, int[] v)");
    }
    
    /**
     * See Programming Pearls 8.3 devide and conquer algorithm.
     * @param l the start index, usualy = 0.
     * @param u the end index of the array, array.length - 1.
     * @return 
     */
    private int divideAndConquer(final int l, final int u, int[] v) {
        
        int lMax = 0;
        int rMax = 0;
        int sum = 0;
        
        if (l > u || v == null) return 0; // Empty array.
        if (l == u) return this.max(0, v[l]); // 1 element.
        
        final int m = (l + u) / 2;
        
        // Go through left side of array v.
        for (int i = m; i >= l; i--) {
            sum += v[i];
            lMax = this.max(lMax, sum);
        }
        
        sum = 0;
        // Go throught right side.
        // Notice error in Bentleys algorithm 8.3 :
        // in the middle to right iteration the i start value must == m + 1
        // or m must be affected with m = array.length / 2.
        for (int i = m + 1; i < u; i++) {
            sum += v[i];
            rMax = this.max(rMax, sum);
        }
        
        return this.max(lMax + rMax, divideAndConquer(l, m, v), divideAndConquer(m + 1, u, v));
    }

    /**
     * Return max integer value from param array.
     * @param iMax Integer array.
     * @return max integer value from param array.
     */
    private int max(Integer ... iMax) {
        int max = Integer.MIN_VALUE;
        for (Integer i : iMax) {
            max = i > max ? i : max; 
        }
        return max;
    }

    /**
     * @param m the sum of max sub vector.
     * @param vLength the length of super vector.
     * @param alg the algorithm used.
     */
    private void display(final int m, final String vLength, final String alg) {
        System.out.println(String.format("Max sum of sub vector.length %s = %d with algorithm %s", vLength, m, alg));
    }
    
}
