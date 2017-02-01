package fr.com.jfish.jfgprogrammingpearls.utils;

import java.util.Arrays;

/**
 *
 * @author thw
 */
public class StringFormatUtils {

    public static final String SPACE = " ";
    
    /**
     * Formats an integer to a string representation defined by length :
     * if length = 5 & i = 3 then return "00001".
     * @param i
     * @param length
     * @return formated integer as string.
     */
    public static String formatInteger(final int i, final int length) {
        String result = String.valueOf(i);
        while (result.length() != length) {
            result = "0" + result;
        }
        return result;
    }
    
    /**
     * Get a words signature : param for "tea" will return "aet".
     * @param s the words as char array.
     * @return the signature.
     */
    public static String getWordSignature(char[] s) {
        Arrays.sort(s);
        String result = String.valueOf(s).replaceAll("-", "");
        result = result.replaceAll("à", "a");
        result = result.replaceAll("à", "a");
        result = result.replaceAll("â", "a");
        result = result.replaceAll("ä", "a");
        result = result.replaceAll("é", "e");
        result = result.replaceAll("ê", "e");
        result = result.replaceAll("ë", "e");
        result = result.replaceAll("è", "e");
        result = result.replaceAll("ô", "o");
        result = result.replaceAll("ö", "o");
        result = result.replaceAll("î", "i");
        result = result.replaceAll("ï", "i");
        result = result.replaceAll("û", "u");
        result = result.replaceAll("ù", "u");
        result = result.replaceAll("ç", "c");
        result = result.replaceAll(" ", "");
        result = result.replaceAll("\\n", "");
        result = result.replaceAll("\\t", "");
        return result;
    }
    
}
