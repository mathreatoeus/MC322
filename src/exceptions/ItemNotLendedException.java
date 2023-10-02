package exceptions;

public class ItemNotLendedException extends Exception {
    // Private Attributes ---------------------------------------------------------------
    private final String message;

    // Constructor ----------------------------------------------------------------------
    public ItemNotLendedException(String message) {
        super(message);
        this.message = message;
    }

    // Getters --------------------------------------------------------------------------
    public String getMessage() {
        return message;
    }
}
