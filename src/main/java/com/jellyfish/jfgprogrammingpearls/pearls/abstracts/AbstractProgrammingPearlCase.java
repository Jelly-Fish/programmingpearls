/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jellyfish.jfgprogrammingpearls.pearls.abstracts;

import com.jellyfish.jfgprogrammingpearls.ui.Console;
import com.jellyfish.jfgprogrammingpearls.ui.Writable;

/**
 *
 * @author thw
 */
public class AbstractProgrammingPearlCase {
    
    public static final Writable writer = new Console();
    
    public Writable getWriter() {
        return AbstractProgrammingPearlCase.writer;
    }
    
}
