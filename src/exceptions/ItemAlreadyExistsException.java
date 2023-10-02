package exceptions;

public class ItemAlreadyExistsException extends Exception {
    // Constructor ----------------------------------------------------------------------
    public ItemAlreadyExistsException(String message) {
        super(message);
    }
}
