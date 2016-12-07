package dao.type.sqlite;

import dao.factory.ProductDAO;
import dao.model.Product;
import dao.model.ProductComparator;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

import java.io.File;
import java.sql.*;
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

        List<Product> productList = new ArrayList<Product>();
        Connection connection = null;
        try {
            connection = SqLiteDaoFactory.createConnection();
            PreparedStatement stmt = connection.prepareStatement("select * from products");
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                File image = createFile(rs.getString("image"));
                String description = rs.getString("description");
                productList.add(new Product(id, name, price, image, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            SqLiteDaoFactory.closeConnection(connection);
        }
        return productList;
    }

    private File createFile(String filePath)
    {
        File result = null;
        try {
            result = filePath == null ? null : new File(filePath);
        } catch  (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int addProduct(Product product) {
        int additionalRowId = -1;
        final String SQL = "insert into products(name, price, image, description) values(?, ?, ? ,?)";
        Connection connection = null;
        try {
            connection = SqLiteDaoFactory.createConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getPriсe());
            stmt.setString(3, product.getImage() == null ? null : product.getImage().toString());
            stmt.setString(4, product.getDescription());
            if(stmt.executeUpdate() > 0)
            {
                if (stmt.getGeneratedKeys().next()) {
                    additionalRowId = stmt.getGeneratedKeys().getInt(1);
                }
                else
                {
                    throw  new SQLException("Can't get id of product.");
                }
            }
            else
            {
                throw new SQLException("Can not add product to database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            SqLiteDaoFactory.closeConnection(connection);
        }
        return additionalRowId;
    }

    public boolean updateProduct(Product product) {
        boolean isUpdated = false;
        final String SQL = "update products set name = ?, price = ?, image = ?, description = ? where id = ?";
        Connection connection = null;
        try {
            connection = SqLiteDaoFactory.createConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL);
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getPriсe());
            stmt.setString(3, product.getImage() == null ? null : product.getImage().toString());
            stmt.setString(4, product.getDescription());
            stmt.setInt(5, product.getId());

            if(stmt.executeUpdate() > 0) {
                isUpdated = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqLiteDaoFactory.closeConnection(connection);
        }
        return isUpdated;
    }

    public boolean deleteProduct(Product product) {
        return false;
    }

    public boolean deleteProduct(int id) {
        return false;
    }
}
