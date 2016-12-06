package dao.type.mysql;

import dao.factory.DaoFactory;
import dao.factory.PersonDAO;
import dao.factory.ProductDAO;

/**
 * Created by di on 29.11.16.
 */
public class MySqlDaoFactory extends DaoFactory {
    public MySqlDaoFactory() throws Exception
    {
        throw new Exception("My sql dao factory does not realized.");
    }

    public PersonDAO getPersonDAO() throws Exception {
        throw new Exception("My sql person dao factory does not realized.");
    }

    public ProductDAO getProductDAO() throws Exception {
        throw new Exception("My sql product dao factory does not realized.");
    }
}
