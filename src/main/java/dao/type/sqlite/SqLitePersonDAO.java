package dao.type.sqlite;

import dao.factory.DaoFactory;
import dao.factory.PersonDAO;
import dao.model.Person;

import java.sql.*;

/**
 * Created by di on 29.11.16.
 */
public class SqLitePersonDAO implements PersonDAO {
    /*
     * Method selects person with specified identifier from database
     * returns Person object with fields values from database
     */
    public Person getPerson(int id) {
        Person person = null;
        Connection connection = null;
        try {
            connection = SqLiteDaoFactory.createConnection();
            PreparedStatement stmt = connection.prepareStatement("select * from Persons where id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                int personId = rs.getInt("id");
                String personLastName = rs.getString("lastName");
                String personFirstName = rs.getString("firstName");
                person = new Person(personId, personLastName, personFirstName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            SqLiteDaoFactory.closeConnection(connection);
            return person;
        }
    }

    /*
     * Method adds new person into data base with Last Name and First Name
     * returns identifier of new row
     */
    public int insertPerson(String lastName, String firstName) {
        int id = -1;
        Connection connection = null;
        try {
            connection = SqLiteDaoFactory.createConnection();
            PreparedStatement stmt = connection.prepareStatement("insert into Persons(lastName, firstName) values(?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, lastName);
            stmt.setString(2, firstName);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            while(rs.next())
            {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            SqLiteDaoFactory.closeConnection(connection);
            return id;
        }
    }

    /*
     * Method deletes row by identifier
     * returns row deleting status
     */
    public boolean deletePerson(int id) {
        boolean isDeleted = false;
        Connection connection = null;
        try {
            connection = SqLiteDaoFactory.createConnection();
            PreparedStatement stmt = connection.prepareStatement("delete from Persons where id=?");
            stmt.setInt(1, id);
            if(stmt.executeUpdate() > 0)
            {
                isDeleted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            SqLiteDaoFactory.closeConnection(connection);
            return isDeleted;
        }
    }
}
