package fr.com.jfish.jfgprogrammingpearls.utils;

import java.io.File;

/**
 *
 * @author thw
 */
public class FileUtils {
    
    /**
     * @param directory to purge.
     */
    public static void purge(final File directory) {
        for (File file: directory.listFiles()) {
            if (file.isDirectory()) FileUtils.purge(file);
            file.delete();
        }
    }
    
}
