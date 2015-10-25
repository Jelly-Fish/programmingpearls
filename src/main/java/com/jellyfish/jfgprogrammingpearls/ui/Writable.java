package com.jellyfish.jfgprogrammingpearls.ui;

/**
 *
 * @author thw
 */
public interface Writable {
    
    /**
     * Print a new line to ui component.
     * @param l the line to print that will be completed with \n.
     */
    void println(final String l);
    
    /**
     * Print a new string to ui component.
     * @param e the String element to print that will not be completed with \n.
     */
    void print(final String e);
    
}
