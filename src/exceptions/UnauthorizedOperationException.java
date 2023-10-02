package exceptions;

public class UnauthorizedOperationException extends Exception {
    // Private Attributes ---------------------------------------------------------------
    private final String operation;

    // Constructor ----------------------------------------------------------------------
    public UnauthorizedOperationException(String message, String operation) {
        super(message);
        this.operation = operation;
    }

    // Getters --------------------------------------------------------------------------
    public String getOperation() {
        return operation;
    }
}
