package com.jellyfish.jfgprogrammingpearls.exceptions;

/**
 *
 * @author thw
 */
public class StopwatchException extends PPException {

    public StopwatchException(final String message) {
        super(message);
    }

    public StopwatchException() {
        super("Stop watch is already running");
    }
    
}
