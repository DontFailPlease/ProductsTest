package dao.type.sqlite;

import dao.factory.ProductDAO;
import dao.model.Product;
import dao.model.ProductComparator;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by di on 05.12.16.
 */
public class SqLiteProductDAO implements ProductDAO {

    public Product getProduct(int id) {
        return null;
    }

    public List<Product> getProducts(String name) {
        return null;
    }

    public List<Product> getProductList() {

        List<Product> productList = null;
        Connection connection = null;
        try {
            connection = SqLiteDaoFactory.createConnection();
            PreparedStatement stmt = connection.prepareStatement("select * from products");
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                if(productList == null) {
                    productList = new ArrayList<Product>();
                }

                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String image = rs.getString("image");
                String description = rs.getString("description");
                productList.add(new Product(id, name, price, image, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            SqLiteDaoFactory.closeConnection(connection);
            return productList;
        }
    }

    public int addProduct(Product product) {
        return 0;
    }

    public boolean updateProduct(Product product) {
        return false;
    }

    public boolean deleteProduct(Product product) {
        return false;
    }

    public boolean deleteProduct(int id) {
        return false;
    }
}
