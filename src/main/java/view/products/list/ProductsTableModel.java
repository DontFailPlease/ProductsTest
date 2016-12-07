package view.products.list;

import dao.factory.DaoFactory;
import dao.factory.DaoType;
import dao.factory.ProductDAO;
import dao.model.Product;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Created by di on 04.12.16.
 */
public class ProductsTableModel extends AbstractTableModel {

    private List<String> headers;
    private List<Product> products;
    private ProductDAO dao = DaoFactory.getDaoFactory(DaoType.SqLite).getProductDAO();

    public ProductsTableModel() throws Exception {
        headers = Arrays.asList("id", "name", "price", "description");
        this.products = dao.getProductList();
    }

    public Product getProduct(int indexInModel)
    {
        return indexInModel >= 0 ? products.get(indexInModel) : null;
    }

    public void addProduct(String name, int price, File imageFile, String description) {
        Product product = new Product(name, price, imageFile, description);
        int generatedId = dao.addProduct(product);
        product.setId(generatedId);
        this.products.add(product);
        this.fireTableDataChanged();
    }

    public void updateProduct(Product productForUpdate, String newName, int newPrice, File newImage, String newDescription)
    {
        int index = products.indexOf(productForUpdate);
        if(index >= 0) {
            products.get(index).setName(newName);
            products.get(index).setPriсe(newPrice);
            products.get(index).setImage(newImage);
            products.get(index).setDescription(newDescription);
            this.fireTableDataChanged();
        }
        dao.updateProduct(products.get(index));
    }

    @Override
    public int getRowCount() {

        return products == null ? 0 : products.size();
    }
    @Override
    public int getColumnCount() {

        return headers.size();
    }
    @Override
    public String getColumnName(int columnIndex) {
        return headers.get(columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex % 2 == 0) {
            return Integer.class;
        } else {
            return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return products.get(rowIndex).elementAt(columnIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        products.get(rowIndex).setElementAt(columnIndex, aValue);
    }

}
