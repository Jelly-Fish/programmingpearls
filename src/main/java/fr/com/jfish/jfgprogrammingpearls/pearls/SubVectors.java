package fr.com.jfish.jfgprogrammingpearls.pearls;

import fr.com.jfish.jfgprogrammingpearls.exceptions.StopwatchException;
import fr.com.jfish.jfgprogrammingpearls.exceptions.SubArrayNotFoundException;
import fr.com.jfish.jfgprogrammingpearls.pearls.abstracts.AbstractProgrammingPearlCase;
import fr.com.jfish.jfgprogrammingpearls.utils.ArrayUtils;
import fr.com.jfish.jfgprogrammingpearls.utils.StopwatchUtils;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thw
 */
public class SubVectors extends AbstractProgrammingPearlCase  {
    
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
     * Desired generic output.
     */
    private final String output = "Max sum of sub vector.length %s = %d with algorithm %s";
    
    /**
     * The end index of sub vector.
     */
    public int subVectorEndIndex = -1;

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
        try {
            StopwatchUtils.start();
            final int r = divideAndConquer(0, this.vector.length - 1, this.vector);
            final String inf = String.format("divideAndConquer(0, v.length - 1, int[] v); runtime=%d ns", StopwatchUtils.stopNS());
            writer.println(String.format(output, this.vector.length, r, inf));
        } catch (final StopwatchException ex) {
            Logger.getLogger(SubVectors.class.getName()).log(Level.SEVERE, null, ex);
            writer.println(ex.getMessage());
        }
    }
    
    /**
     * 8.4 of Programming Pearls.
     */
    public void runScan() {
        try {
            StopwatchUtils.start();
            final int r = scan(this.vector);
            final String inf = String.format("scan(int[] v); runtime=%d ns", StopwatchUtils.stopNS());
            writer.println(String.format(output, this.vector.length, r, inf));
        } catch (final StopwatchException ex) {
            Logger.getLogger(SubVectors.class.getName()).log(Level.SEVERE, null, ex);
            writer.println(ex.getMessage());
        }
    }
    
    /**
     * 8.4 of Programming Pearls.
     */
    public void runScan2() {
        try {
            StopwatchUtils.start();
            final int r = ArrayUtils.arraySum(scan2(this.vector));
            final String inf = String.format("scan2(int[] v); runtime=%d ns", StopwatchUtils.stopNS());
            writer.println(String.format(output, this.vector.length, r, inf));
        } catch (final StopwatchException | SubArrayNotFoundException ex) {
            Logger.getLogger(SubVectors.class.getName()).log(Level.SEVERE, null, ex);
            writer.println(ex.getMessage());
        }
    }
    
    /**
     * See Programming Pearls 8.4 scan algorithm.
     * @param v the main array vector.
     * @return max sub vector sum.
     */
    private int scan(int[] v) {
        
        int maxSoFar = 0, maxEndingHere = 0;
        for (int i = 0; i < v.length; i++) {
            maxEndingHere = ArrayUtils.max(maxEndingHere + v[i], 0);
            maxSoFar = ArrayUtils.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
    
    /**
     * Scans for max sum sub vector & the sub vertor as an array.
     * @param v main vector to scan.
     * @return max sum sub vector.
     * @throws SubArrayNotFoundException 
     */
    public int[] scan2(int[] v) throws SubArrayNotFoundException {
        
        // integer eI = end index of sub vector in v, sI = start index.
        @SuppressWarnings("UnusedAssignment")
        int maxSoFar = 0, maxEndingHere = 0, tempMax = 0, eI = 0;

        for (int i = 0; i < v.length; i++) {
            maxEndingHere = ArrayUtils.max(maxEndingHere + v[i], 0);
            tempMax = ArrayUtils.max(maxSoFar, maxEndingHere);
            eI = tempMax > maxSoFar ? i : eI;
            maxSoFar = tempMax > maxSoFar ? tempMax : maxSoFar;
        }
        
        this.subVectorEndIndex = eI;
        return ArrayUtils.getSubArray(maxSoFar, v, eI);
    }
    
    /**
     * @return max sum sub vector.
     * @throws SubArrayNotFoundException 
     */
    public int[] scan2() throws SubArrayNotFoundException {
        return this.scan2(this.vector);
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
        if (l == u) return ArrayUtils.max(0, v[l]); // 1 element.
        
        final int m = (l + u) / 2;
        
        // Go through left side of array v.
        for (int i = m; i >= l; i--) {
            sum += v[i];
            lMax = ArrayUtils.max(lMax, sum);
        }
        
        sum = 0;
        // Go throught right side.
        // Notice error in Bentleys algorithm 8.3 :
        // in the middle to right iteration the i start value must == m + 1
        // or m must be affected with m = array.length / 2.
        for (int i = m + 1; i < u; i++) {
            sum += v[i];
            rMax = ArrayUtils.max(rMax, sum);
        }
        
        return ArrayUtils.max(lMax + rMax, divideAndConquer(l, m, v), divideAndConquer(m + 1, u, v));
    }
    
}
