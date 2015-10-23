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
     * 8.4 of Programming Pearls.
     */
    public void runScan() {
        display(scan(this.vector), String.valueOf(this.vector.length), "scan(int[] v)");
    }
    
    /**
     * 8.4 of Programming Pearls.
     */
    public void runScan2() {
        display(scan2(this.vector), String.valueOf(this.vector.length), "scan2(int[] v)");
    }
    
    /**
     * See Programming Pearls 8.4 scan algorithm.
     * @param v the main array vector.
     * @return max sub vector sum.
     */
    private int scan(int[] v) {
        
        int maxSoFar = 0, maxEndingHere = 0;
        for (int i = 0; i < v.length; i++) {
            maxEndingHere = this.max(maxEndingHere + v[i], 0);
            maxSoFar = this.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
    
    /**
     * Scans for max sum sub vector & the sub vertor as an array.
     * @param v main vector to scan.
     * @return sub vector sum value.
     */
    private int scan2(int[] v) {
        return this.vectorSum(this.getSubVector(this.scan(vector), v));
    }
    
    
    /**
     * See Programming Pearls 8.3 devide and conquer algorithm.
     * @param l left start index (usually 0).
     * @param u the up side of main vector (usually array length - 1).
     * @param v the main array vector.
     * @return max sub vector sum.
     */
    private int divideAndConquer(final int l, final int u, int[] v) {
        
        int lMax = 0, rMax = 0, sum = 0;
        
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

    /**
     * @param v the vector to sum up.
     * @return sum of all entries in the vector.
     */
    private int vectorSum(final int[] v) {
        int result = 0;
        for (int i = 0; i < v.length; i++) {
            result += v[i];
        }
        return result;
    }

    /**
     * 
     * @param maxSum
     * @param v main vector.
     * @return the max sum sub vector as a int array that contains a copy of
     * the sub vector.
     */
    private int[] getSubVector(final int maxSum, int[] v) {
        
        // N^2 :S
        for (int i = 0; i < v.length; i++) {
            for (int j = i; j < v.length; j++) {
                if (this.vectorSum(java.util.Arrays.copyOfRange(v, i, j)) == maxSum) {
                    return java.util.Arrays.copyOfRange(v, i, j);
                }
            }
        }
        return v;
    }
    
}
