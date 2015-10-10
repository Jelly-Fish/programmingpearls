package com.jellyfish.jfgprogrammingpearls.utils;

/**
 *
 * @author thw
 */
public class StringFormatUtils {
    
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
    
}
