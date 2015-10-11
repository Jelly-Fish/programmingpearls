package com.jellyfish.jfgprogrammingpearls.pearls;

import com.jellyfish.jfgprogrammingpearls.utils.StringFormatUtils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
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
     * Peform the job - Jon Bentley's "Programming Pearls" chapter II :
     * Sign all words in the file, then squash by word signature, finally
     * sort array of anagrams and write to output file.
     */
    public void aHa() {
        try {
            this.signWords(this.frenchWordsFilePath, this.signedWordsFilePath);
            final String[] squashedAnagrams = 
                    this.squash(this.getSignedWordsArray(this.signedWordsFilePath));
            this.sortSignedWords(squashedAnagrams);
            this.write(squashedAnagrams, this.anagramsFilePath);
        } catch (final IOException ioex) {
            Logger.getLogger(AHAAlgorithms.class.getName()).log(Level.SEVERE, null, ioex);
        }
    }

    private void signWords(final String dictionaryFilePath, final String outputFile) throws IOException {
        
        try(PrintWriter writer = new PrintWriter(outputFile)) {
            try(BufferedReader br = new BufferedReader(new FileReader(dictionaryFilePath))) {
                for(String l; (l = br.readLine()) != null;) {
                    // Discard x2 words on the same line (discard "red car").
                    if (!l.contains(StringFormatUtils.SPACE)) { 
                        writer.println(String.format("%s %s",
                                StringFormatUtils.getWordSignature(l.toLowerCase().toCharArray()), l));
                    }
                }
                br.close();
            }
            writer.flush();
        }
    }
    
    private void sortSignedWords(String[] array) {
        // Using java.util.Arrays.sort(array) will throw a NullPointerException
        // because the array contains multiple word lines and not closed strings.
        // FIXME...
    }

    private String[] getSignedWordsArray(final String file) throws IOException {

        final List<String> entries = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String l; (l = br.readLine()) != null;) {
                entries.add(l);
            }
            br.close();
        }
        final String[] signedWords = new String[entries.size()];
        entries.toArray(signedWords);
        return signedWords;
    }

    private String[] squash(final String[] array) throws IOException, FileNotFoundException {
        
        final HashMap<String, List<String>> entries = new HashMap<>();
        String[] data = null;
        for (String value : array) {
            data = value.split(StringFormatUtils.SPACE);
            if (this.checkSignatureWordAssociation(data[0], data[1])) {
                if (!entries.containsKey(data[0])) {
                    List<String> l = new ArrayList<>();
                    l.add(data[1]);
                    entries.put(data[0], l);
                } else {
                    entries.get(data[0]).add(data[1]);
                }
            }
        }
        
        final List<String> anagrams = new ArrayList<>();
        for (Map.Entry<String, List<String>> entrySet : entries.entrySet()) {
            if (entrySet.getValue().size() > 1) {
                String val = "";
                for (String s : entrySet.getValue()) val += s + StringFormatUtils.SPACE;
                anagrams.add(val.substring(0, val.length() - 1));
            }
        }
        
        final String[] squashed = new String[anagrams.size()];
        anagrams.toArray(squashed);
        return squashed;
    }

    private void write(final String[] squashedAnagrams, final String path) 
            throws UnsupportedEncodingException, FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(path, "UTF-8")) {
            for (String s : squashedAnagrams) writer.println(s);
            writer.flush();
        }
    }

    private boolean checkSignatureWordAssociation(final String sig, final String word) {
        return sig != null && word != null && !sig.isEmpty() && !word.isEmpty() && !word.contains("-");
    }
    
}
