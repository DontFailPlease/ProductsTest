package dao.factory;
import dao.model.Person;

import java.sql.SQLException;

/**
 * Created by di on 29.11.16.
 */
public interface PersonDAO {
    Person getPerson(int id) throws SQLException;
    int insertPerson(String lastName, String firstName);
    boolean deletePerson(int id);
}
