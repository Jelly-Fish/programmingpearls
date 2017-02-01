package fr.com.jfish.jfgprogrammingpearls.utils;

import fr.com.jfish.jfgprogrammingpearls.exceptions.StopwatchException;

/**
 *
 * @author thw
 */
public class StopwatchUtils {
    
    private static boolean running = false;
    private static long startT = 0L;
    
    /**
     * @throws StopwatchException 
     */
    public static final void start() throws StopwatchException {
        if (StopwatchUtils.running) throw new StopwatchException();
        StopwatchUtils.running = true;
        StopwatchUtils.startT = System.nanoTime();
    }
    
    /**
     * @return elapsed time in milliseconds.
     * @throws StopwatchException 
     */
    public static final long stopMS() throws StopwatchException {
        if (!StopwatchUtils.running) throw new StopwatchException();
        StopwatchUtils.running = false;
        return (System.nanoTime() - StopwatchUtils.startT) / 1000000;
    }
    
    /**
     * @return elapsed time in nano seconds.
     * @throws StopwatchException 
     */
    public static final long stopNS() throws StopwatchException {
        if (!StopwatchUtils.running) throw new StopwatchException();
        StopwatchUtils.running = false;
        return (System.nanoTime() - StopwatchUtils.startT);
    }
    
}
