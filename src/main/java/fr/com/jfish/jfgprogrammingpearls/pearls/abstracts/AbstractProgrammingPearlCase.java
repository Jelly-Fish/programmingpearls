package fr.com.jfish.jfgprogrammingpearls.pearls.abstracts;

import fr.com.jfish.jfgprogrammingpearls.ui.Console;
import fr.com.jfish.jfgprogrammingpearls.ui.Writable;

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
