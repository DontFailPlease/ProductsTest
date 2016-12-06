package dao.model;

import java.util.Comparator;

/**
 * Created by di on 05.12.16.
 */
public class ProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
