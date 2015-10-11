package com.jellyfish.jfgprogrammingpearls.pearls;

import com.jellyfish.jfgprogrammingpearls.utils.ArrayUtils;
import com.jellyfish.jfgprogrammingpearls.utils.StringFormatUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.BitSet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thw
 */
public class CrackingTheOyster {

    /**
     * Size or amount of integers to sort - Value from 0 to this value excluded.
     */
    private final int maxIntToSort;

    /**
     * The dat file path.
     */
    private final String file_path = "resources/data/DIGIT_INTERGERS_INPUT";
    
    /**
     * The dat file path.
     */
    private final String output_path = "resources/output/DIGIT_INTERGERS_OUTPUT";

    public CrackingTheOyster(final int maxIntToSort) {
        this.maxIntToSort = maxIntToSort;
        if (!new File(this.file_path).exists()) {
            this.setup();
            System.out.println("/!\\Case needs setup...");
        }
    }

    /**
     * Crack the oyster. 
     */
    public void crack() {

        final BitSet bits = new BitSet(maxIntToSort);

        for (int i = 0; i < bits.size(); i++) {
            bits.set(i, false);
        }

        Scanner scan = null;
        try {
            scan = new Scanner(new File(this.file_path));
        } catch (final FileNotFoundException fnfex) {
            Logger.getLogger(CrackingTheOyster.class.getName()).log(Level.SEVERE, null, fnfex);
        }

        while (scan.hasNextInt()) {
            bits.set(scan.nextInt(), true);
        }
        
        scan.close();
        
        try (final PrintWriter writer = new PrintWriter(new File(this.output_path))) {
            for (int i = 0; i < bits.size(); i++) {
                if (bits.get(i)) {
                    writer.println(i);
                }
            }
            writer.flush();
            writer.close();
        } catch (final FileNotFoundException fnfex) {
            Logger.getLogger(CrackingTheOyster.class.getName()).log(Level.SEVERE, null, fnfex);
        }
    }

    /**
     * This method is not part of the case, it's pupose is to setup the input
     * file if needed so.
     */
    public final void setup() {

        try {
            
            final File file = new File(this.file_path);
            file.createNewFile();
            final int[] integers = new int[this.maxIntToSort];

            for (int i = 0; i < integers.length; i++) {
                integers[i] = i;
            }

            ArrayUtils.shuffleArray(integers);

            final int maxValueLength =  String.valueOf(maxIntToSort - 1).length();
            try (final PrintWriter writer = new PrintWriter(file)) {
                for (int i = 0; i < integers.length; i++) {
                    writer.println(StringFormatUtils.formatInteger(integers[i], maxValueLength));
                }
                writer.flush();
                writer.close();
            }

        } catch (final FileNotFoundException ex) {
            Logger.getLogger(CrackingTheOyster.class.getName()).log(Level.SEVERE, null, ex);
        } catch (final IOException ex) {
            Logger.getLogger(CrackingTheOyster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
