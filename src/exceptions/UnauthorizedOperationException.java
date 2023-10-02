package exceptions;

public class UnauthorizedOperationException extends Exception {
    // Private Attributes ---------------------------------------------------------------
    private final OperationType operation;

    //Enum ------------------------------------------------------------------------------
    public enum OperationType {
        ITEM_REGISTRATION, ITEM_REMOVAL, USER_REGISTRATION, USER_REMOVAL
    }

    // Constructor ----------------------------------------------------------------------
    public UnauthorizedOperationException(String message, OperationType operation) {
        super(message);
        this.operation = operation;
    }

    // Getters --------------------------------------------------------------------------
    public OperationType getOperation() {
        return operation;
    }
}
