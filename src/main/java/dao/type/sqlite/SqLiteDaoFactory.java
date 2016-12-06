package dao.type.sqlite;
import dao.factory.DaoFactory;
import dao.factory.PersonDAO;
import dao.factory.ProductDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by di on 29.11.16.
 */
public class SqLiteDaoFactory extends DaoFactory {
    public static final String PATH = "jdbc:sqlite:/Users/di/Downloads/Remsmed - Anton/remsmed/SQLiteAccess/Shop.sqlite";

    static
    {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(PATH);
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PersonDAO getPersonDAO() {
        return new SqLitePersonDAO();
    }

    public ProductDAO getProductDAO() throws Exception {
        return new SqLiteProductDAO();
    }
}
