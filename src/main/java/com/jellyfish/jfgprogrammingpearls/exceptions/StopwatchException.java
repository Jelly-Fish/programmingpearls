/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
