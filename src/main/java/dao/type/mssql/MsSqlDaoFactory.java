package dao.type.mssql;

import dao.factory.DaoFactory;
import dao.factory.PersonDAO;
import dao.factory.ProductDAO;
import dao.type.mysql.MySqlDaoFactory;

/**
 * Created by di on 29.11.16.
 */
public class MsSqlDaoFactory extends DaoFactory {
    public MsSqlDaoFactory () throws Exception {
        throw new Exception("Ms sql factory does not realize.");
    }

    public PersonDAO getPersonDAO() throws Exception {
        throw new Exception("Ms sql person dao factory does not realized.");
    }

    public ProductDAO getProductDAO() throws Exception {
        throw new Exception("Ms sql product dao factory does not realized.");
    }
}
