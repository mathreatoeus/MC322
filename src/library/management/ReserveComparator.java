package library.management;

import java.util.Comparator;

public class ReserveComparator implements Comparator<Reserve> {
    @Override
    public int compare(Reserve reserve1, Reserve reserve2) {
        // Compare in reverse order for max-heap
        return reserve2.getPickupDate().compareTo(reserve1.getPickupDate());
    }
}
