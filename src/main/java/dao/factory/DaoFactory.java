package dao.factory;
import dao.type.mssql.MsSqlDaoFactory;
import dao.type.sqlite.SqLiteDaoFactory;
import dao.type.mysql.MySqlDaoFactory;

/**
 * Created by di on 29.11.16.
 */
public abstract class DaoFactory {

    public abstract PersonDAO getPersonDAO() throws Exception;
    public abstract ProductDAO getProductDAO() throws Exception;

    public static DaoFactory getDaoFactory(DaoType selectedDaoType) throws Exception {
        switch (selectedDaoType) {
            case SqLite:
                return new SqLiteDaoFactory();
            case MsSql:
                return new MsSqlDaoFactory();
            case MySql:
                return new MySqlDaoFactory();
            default:
                return null;
        }
    }
}
