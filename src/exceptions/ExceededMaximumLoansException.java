package exceptions;

import models.people.Person;
import models.library.management.Loan;
import java.util.LinkedList;

public class ExceededMaximumLoansException extends Exception {
    // Private Attributes ---------------------------------------------------------------
    private final String message;
    private final LinkedList<Loan> loans;
    private final int numOfLoans;

    // Constructor ----------------------------------------------------------------------
    public ExceededMaximumLoansException(String message, Person user) {
        super(message);
        this.message = message;
        this.loans = user.getLoans();
        this.numOfLoans = (this.loans).size();
    }

    // Getters --------------------------------------------------------------------------
    public String getMessage() {
        return message;
    }

    public LinkedList<Loan> getLoans() {
        return loans;
    }

    public int getNumOfLoans() {
        return numOfLoans;
    }
}
