package com.jellyfish.jfgprogrammingpearls;

import com.jellyfish.jfgprogrammingpearls.pearls.AHAAlgorithms;
import com.jellyfish.jfgprogrammingpearls.pearls.CrackingTheOyster;
import com.jellyfish.jfgprogrammingpearls.pearls.SubVectors;
import com.jellyfish.jfgprogrammingpearls.utils.ArrayUtils;
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
        
        /**
         * See Programming Pearls COLUMN 1 :
         */
        final CrackingTheOyster oyster = new CrackingTheOyster(1000000);
        oyster.crack();
        
        /**
         * See Programming Pearls COLUMN 2 :
         */ 
        final AHAAlgorithms aha = new AHAAlgorithms();
        aha.aHa();
        
        /**
         * See Programming Pearls COLUMN 8.
         */
        SubVectors sv = new SubVectors(new int[] { 
            31, -41, 59, 26, -53, 58, 97, -93, -23, 84 
        });
        // = 187 as in Bentley's example.
        sv.runDivideAndConquer();
        sv.runScan();
        sv.runScan2();
          
        sv = new SubVectors(new int[] { 
            31, -41, 59, 26, -53, 58, 97, -93, -23, 84, -43, -54, -32, -43, -11111111,
            -543, -543, 2, 0, -543, -32, 5, 6, -54, -654, 9, 3, 5, -5432, 2, 3, 1, 0,
            0, 0, 0, 1, 2, 3, 4, -54, 0, 0, 32, 0, 1, 2, 3, 2, 1, 2, 3, -43, 0, 0, 0,
            -34, 100, 100, 200, -200, 300, 400, -543, 5, 54, -43, 0, 43
        });
        // = 900 (sub vector = 100, 100, 200, -200, 300, 400).
        sv.runDivideAndConquer();
        sv.runScan();
        sv.runScan2();
        
        // = ?
        sv = new SubVectors(ArrayUtils.randomIntegers(1000));
        sv.runDivideAndConquer();
        sv.runScan();
        sv.runScan2();
    }
    
}
