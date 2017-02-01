package fr.com.jfish.jfgprogrammingpearls.pearls;

import fr.com.jfish.jfgprogrammingpearls.pearls.abstracts.AbstractProgrammingPearlCase;
import fr.com.jfish.jfgprogrammingpearls.utils.StringFormatUtils;
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
public class AHAAlgorithms extends AbstractProgrammingPearlCase {
    
    /**
     * Path to the dictionary file : french words only.
     */
    private final String dictionnaireFilePath = "resources/data/words-french";
    
    /**
     * Signed words file output.
     */
    private final String signedWordsFilePath = "resources/output/signedwords";
    
    /**
     * Sorted & squashed anagrams.
     */
    private final String anagramsFilePath = "resources/output/sorted-signed-anagrams.txt";
    
    /**
     * Peform the job - Jon Bentley's "Programming Pearls" chapter II :
     * Sign all words in the file, then squash by word signature, finally
     * sort array of anagrams and write to output file.
     */
    public void aHa() {
        try {
            this.signWords(this.dictionnaireFilePath, this.signedWordsFilePath);
            final String[] squashedAnagrams = 
                    this.squash(this.getSignedWordsArray(this.signedWordsFilePath));
            this.write(this.sortSignedWords(squashedAnagrams), this.anagramsFilePath);
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
    
    private String[] sortSignedWords(final String[] array) {
        
        final String[] data = new String[array.length];
        final HashMap<String, String> anagrams = new HashMap<>();
        
        for (int i = 0; i < array.length; i++) {
            int firstSpaceIndex = array[i].indexOf(StringFormatUtils.SPACE);
            data[i] = array[i].substring(0, firstSpaceIndex);
            anagrams.put(data[i], array[i].substring(firstSpaceIndex, array[i].length()));
        }
        
        java.util.Arrays.sort(data);
        
        for (int i = 0; i < data.length; i++) {
            data[i] += anagrams.get(data[i]);
        }
        
        return data;
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
                } else if (!this.checkListContainsWord(data[1], entries.get(data[0]))) {
                    entries.get(data[0]).add(data[1]);
                }
            }
        }
        
        final List<String> anagrams = new ArrayList<>();
        for (Map.Entry<String, List<String>> entrySet : entries.entrySet()) {
            if (entrySet.getValue().size() > 1) {
                String val = entrySet.getKey() + StringFormatUtils.SPACE;
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

    private boolean checkListContainsWord(String word, final List<String> entries) {
        word = word.toLowerCase();
        for (String e : entries) {
            if (e.toLowerCase().equals(word)) return true;
        }
        return false;
    }
    
}
