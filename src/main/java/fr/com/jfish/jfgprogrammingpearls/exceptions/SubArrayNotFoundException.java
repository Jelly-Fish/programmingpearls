package fr.com.jfish.jfgprogrammingpearls.exceptions;

/**
 *
 * @author thw
 */
public class SubArrayNotFoundException extends PPException {

    public SubArrayNotFoundException(final String message) {
        super(message);
    }
    
    public SubArrayNotFoundException() {
        super("No sub array found for defined parameters.");
    }
    
}
