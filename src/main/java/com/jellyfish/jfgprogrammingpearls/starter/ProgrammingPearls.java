package com.jellyfish.jfgprogrammingpearls.starter;

import com.jellyfish.jfgprogrammingpearls.exceptions.StopwatchException;
import com.jellyfish.jfgprogrammingpearls.exceptions.SubArrayNotFoundException;
import com.jellyfish.jfgprogrammingpearls.pearls.AHAAlgorithms;
import com.jellyfish.jfgprogrammingpearls.pearls.CrackingTheOyster;
import com.jellyfish.jfgprogrammingpearls.pearls.SubVectors;
import com.jellyfish.jfgprogrammingpearls.ui.Console;
import com.jellyfish.jfgprogrammingpearls.utils.ArrayUtils;
import com.jellyfish.jfgprogrammingpearls.utils.FileUtils;
import com.jellyfish.jfgprogrammingpearls.utils.StopwatchUtils;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author thw
 */
public class ProgrammingPearls {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            
            // <editor-fold defaultstate="collapsed" desc="UI Manager">
            try {
                // Set System L&F
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName());
            } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                System.err.println("Look & feel setup failed.");
            }
            //</editor-fold>
            
            FileUtils.purge(new File("resources/output"));
            
            /**
             * See Programming Pearls COLUMN 1 :
             */
            final int arraySizeToSort = 1000000;
            final String inf = "bit map sort for integer array of %d entries completed in %d ns";
            final CrackingTheOyster oyster = new CrackingTheOyster(arraySizeToSort);
            oyster.getWriter().println("Programming Pearls COLUMN 1 :");
            StopwatchUtils.start();
            oyster.crack();
            oyster.getWriter().println(String.format(inf, arraySizeToSort, StopwatchUtils.stopNS()));
            
            
            /**
             * See Programming Pearls COLUMN 2 :
             */
//            final AHAAlgorithms aha = new AHAAlgorithms();
//            aha.getWriter().println(
//                    "\nSee Programming Pearls COLUMN 2 : 'AHA ALGORITHMS' or anagram sorting." +
//                    "\nThis section is not timed atm. Yet output file of sorted anagrams is" +
//                    "\nwriten on evry run in directory programmingpearls/resources/output/"
//            );
//            aha.aHa();
//            
//            /**
//             * See Programming Pearls COLUMN 8.
//             */
//            SubVectors sv = new SubVectors(new int[] {
//                31, -41, 59, 26, -53, 58, 97, -93, -23, 84
//            });
//            aha.getWriter().println(
//                    "\nSee Programming Pearls COLUMN 8 : sub vector search algorithms." +
//                    "\nOnly algorithms 8.3 & 8.4 are implemented and timed."
//            );
//            // = 187 as in Bentley's example.
//            sv.runDivideAndConquer();
//            sv.runScan();
//            sv.runScan2();
//            
//            sv = new SubVectors(new int[] {
//                31, -41, 59, 26, -53, 58, 97, -93, -23, 84, -43, -54, -32, -43, -11111111,
//                -543, -543, 2, 0, -543, -32, 5, 6, -54, -654, 9, 3, 5, -5432, 2, 3, 1, 0,
//                0, 0, 0, 1, 2, 3, 4, -54, 0, 0, 32, 0, 1, 2, 3, 2, 1, 2, 3, -43, 0, 0, 0,
//                -34, 100, 100, 200, -200, 300, 400, -543, 5, 54, -43, 0, 43
//            });
//            // = 900 (sub vector = 100, 100, 200, -200, 300, 400).
//            sv.runDivideAndConquer();
//            sv.runScan();
//            sv.runScan2();
//            
//            // = ?
//            sv = new SubVectors(ArrayUtils.randomIntegers(1000));
//            sv.runDivideAndConquer();
//            sv.runScan();
//            sv.runScan2();
            
        } catch (final StopwatchException ex) {
            Logger.getLogger(ProgrammingPearls.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
