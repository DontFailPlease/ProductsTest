package view.products.list;

import dao.factory.DaoFactory;
import dao.factory.DaoType;
import dao.model.Product;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by di on 04.12.16.
 */
public class ProductsTableModel implements TableModel {

    private List<String> headers;
    private List<Product> products;

    public ProductsTableModel() throws Exception {
        headers = Arrays.asList("id", "name", "price", "description");
        this.products = DaoFactory.getDaoFactory(DaoType.SqLite).getProductDAO().getProductList();
    }

    public Product getProduct(int index)
    {
        return index >= 0 ? products.get(index) : null;
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

    public void addTableModelListener(TableModelListener l) {

    }

    public void removeTableModelListener(TableModelListener l) {

    }
}
