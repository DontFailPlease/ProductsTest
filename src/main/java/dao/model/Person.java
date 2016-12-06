package dao.model;

import java.io.Serializable;

/**
 * Created by di on 29.11.16.
 */
public class Person implements Serializable{

    int id = -1;
    String lastName = null;
    String firstName = null;

    public Person(String lastName, String firstName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(int id, String lastName, String firstName)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
