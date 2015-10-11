package com.jellyfish.jfgprogrammingpearls.pearls;

import com.jellyfish.jfgprogrammingpearls.utils.StringFormatUtils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thw
 */
public class AHAAlgorithms {
    
    /**
     * Path to the dictionary file.
     */
    private final String frenchWordsFilePath = "resources/data/liste_francais.txt";
    
    /**
     * Signed words file output.
     */
    private final String signedWordsFilePath = "resources/output/signedwords.txt";
    
    /**
     * Sorted & squashed anagrams.
     */
    private final String anagramsFilePath = "resources/output/anagrams.txt";
    
    /**
     * Peform the job.
     */
    public void aHa() {
        try {
            this.signWords();
            this.squash(this.sortBySignatures());
            //this.sortBySignatures();
        } catch (final IOException ioex) {
            Logger.getLogger(AHAAlgorithms.class.getName()).log(Level.SEVERE, null, ioex);
        }
    }
    
    /**
     * Sign each word.
     */
    private void signWords() throws IOException {
        
        final PrintWriter writer = new PrintWriter(this.signedWordsFilePath);
        try(BufferedReader br = new BufferedReader(new FileReader(this.frenchWordsFilePath))) {
            for(String l; (l = br.readLine()) != null;) {
                if (!l.contains(StringFormatUtils.SPACE)) { // Discard when é words on the same line (discard "red car").
                    writer.println(String.format("%s %s",
                            StringFormatUtils.getWordSignature(l.toLowerCase().toCharArray()), l));
                }
            }
            br.close();
        }
        writer.flush();
        writer.close();
    }

    private String[] sortBySignatures() throws IOException {

        final List<String> entries = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(this.signedWordsFilePath))) {
            for(String l; (l = br.readLine()) != null;) {
                entries.add(l);
            }
        }
        final String[] toSort = new String[entries.size()];
        entries.toArray(toSort);
        // TODO : implement merge sort instead of calling java.util.Arrays.
        //Arrays.sort(entries.toArray(toSort));
        return toSort;
    }

    private void squash(final String[] array) throws IOException, FileNotFoundException {
        
        final HashMap<String, List<String>> anagrams = new HashMap<>();
        String[] data = null;
        for (String value : array) {
            data = value.split(StringFormatUtils.SPACE);
            if (data.length == 2 && data[1] != null && !data[1].isEmpty()) {
                if (!anagrams.containsKey(data[0])) {
                    List<String> l = new ArrayList<>();
                    l.add(data[1]);
                    anagrams.put(data[0], l);
                } else {
                    anagrams.get(data[0]).add(data[1]);
                }
            }
        }
        
        final PrintWriter writer = new PrintWriter(this.anagramsFilePath, "UTF-8");
        for (List<String> list : anagrams.values()) {
            if (list.size() > 1) {
                StringBuilder output = new StringBuilder();
                for (String s : list) {
                   output.append(StringFormatUtils.SPACE + s);
                }
                writer.println(output);
            }
        }
        writer.flush();
        writer.close();
    }
    
}
