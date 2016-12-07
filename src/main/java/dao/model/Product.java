package dao.model;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * create table products(id int auto_increment, name varchar(20) not null,
 * price int, image varchar(225), description varchar(50), saleId int,
 * discountId int,
 * foreign key(saleId) references sales(id) on delete cascade,
 * foreign key(discountId) references discount(id) on delete cascade, primary key(id))
 */
public class Product implements Serializable {

    private Map<Integer, Object> columnsMap;
    private int id;
    private String name;
    private int price;
    private File image;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriсe() {
        return price;
    }

    public void setPriсe(int priсe) {
        this.price = priсe;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Product(String name, int priсe, File image, String description) {
        this.name = name;
        this.price = priсe;
        this.image = image;
        this.description = description;
    }

    public Product(int id, String name, int priсe, File image, String description) {
        this.id = id;
        this.name = name;
        this.price = priсe;
        this.image = image;
        this.description = description;
    }

    public Object elementAt(int fieldIndex)
    {
        switch(fieldIndex)
        {
            case 0:
                return id;
            case 1:
                return name;
            case 2:
                return price;
            case 3:
                return description;
            default:
                throw new IndexOutOfBoundsException("Index \"" + fieldIndex + "\" out of range columns number.");
        }
    }

    public void setElementAt(int fieldIndex, Object value)
    {
        switch(fieldIndex)
        {
            case 0:
                setId(Integer.parseInt(value.toString()));
            case 1:
                setName(value.toString());
            case 2:
                setPriсe(Integer.parseInt(value.toString()));
            case 3:
                setDescription(value.toString());
            default:
                throw new IndexOutOfBoundsException("Index \"" + fieldIndex + "\" out of range columns number.");
        }
    }
}
