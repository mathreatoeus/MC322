package exceptions;

import models.library.content.Item;

public class DamagedItemException extends Exception {
    // Private Attributes ---------------------------------------------------------------
    private final Item item;

    // Constructor ----------------------------------------------------------------------
    public DamagedItemException(String message, Item item) {
        super(message);
        this.item = item;
    }

    // Getters --------------------------------------------------------------------------
    public Item getItem() {
        return item;
    }
}
