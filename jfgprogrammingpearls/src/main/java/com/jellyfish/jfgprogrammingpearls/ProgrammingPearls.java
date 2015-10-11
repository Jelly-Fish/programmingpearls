package com.jellyfish.jfgprogrammingpearls;

import com.jellyfish.jfgprogrammingpearls.pearls.AHAAlgorithms;
import com.jellyfish.jfgprogrammingpearls.pearls.CrackingTheOyster;
import com.jellyfish.jfgprogrammingpearls.utils.FileUtils;
import java.io.File;

/**
 *
 * @author thw
 */
public class ProgrammingPearls {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileUtils.purge(new File("resources/output"));
        final CrackingTheOyster oyster = new CrackingTheOyster(1000000);
        oyster.crack();
        final AHAAlgorithms aha = new AHAAlgorithms();
        aha.aHa();
    }
    
}
