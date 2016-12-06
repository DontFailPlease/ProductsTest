package dao.factory;

import dao.model.Product;
import java.util.List;

/**
 * Created by di on 05.12.16.
 */
public interface ProductDAO {

    Product getProduct(int id);
    List<Product> getProducts(String name);
    List<Product> getProductList();

    int addProduct(Product product);
    boolean updateProduct(Product product);

    boolean deleteProduct(Product product);
    boolean deleteProduct(int id);
}
