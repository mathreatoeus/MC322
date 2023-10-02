package exceptions;

import models.library.content.Item;

public class ItemUnavailableException extends Exception {
    // Private Attributes ---------------------------------------------------------------
    private final Item item;

    // Constructor ----------------------------------------------------------------------
    public ItemUnavailableException(String message, Item item) {
        super(message);
        this.item = item;
    }

    // Getters --------------------------------------------------------------------------
    public Item getItem() {
        return item;
    }
}
