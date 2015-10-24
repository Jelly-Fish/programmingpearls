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
public class SubArrayNotFoundException extends PPException {

    public SubArrayNotFoundException(final String message) {
        super(message);
    }
    
    public SubArrayNotFoundException() {
        super("No sub array found for defined parameters.");
    }
    
}
