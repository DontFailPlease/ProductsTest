package view.products.list;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;

/**
 * Created by di on 04.12.16.
 */
public class Products extends JPanel{

    JScrollPane productsScrollPane;
    JTable productsTable;

    public Products() throws Exception {

        productsTable = new JTable(new ProductsTableModel());
        productsScrollPane = new JScrollPane(productsTable);

        setColumnSizeByContentAndHeader();
        this.setLayout(new BorderLayout());
        this.add(productsScrollPane, BorderLayout.CENTER);
    }

    public void setSize(Dimension dimension)
    {
        productsScrollPane.setPreferredSize(dimension);
    }

    private void setColumnSizeByContentAndHeader()
    {
        if(productsTable != null)
        {
            int accumulativeColumnsWidth = 0;
            int columnWidth = 0;
            final int MAX_COLUMN_WIDTH = productsScrollPane.getPreferredSize().width;

            productsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            TableColumnModel columnHeaderModel = productsTable.getTableHeader().getColumnModel();
            TableColumnModel columnModel = productsTable.getColumnModel();

            final int COLUMN_COUNT = columnModel.getColumnCount();
            for(int columnNumber = 0; columnNumber < COLUMN_COUNT; columnNumber ++)
            {
                if(columnNumber != COLUMN_COUNT - 1) {
                    TableColumn headerColumn = columnHeaderModel.getColumn(columnNumber);
                    TableCellRenderer headersRenderer = productsTable.getTableHeader().getDefaultRenderer();
                    Component header = headersRenderer.getTableCellRendererComponent(
                            productsTable,
                            headerColumn.getHeaderValue(),
                            false,
                            false,
                            -1,
                            columnNumber
                    );
                    columnWidth = header.getPreferredSize().width + 1;

                    for (int rowNumber = 0; rowNumber < productsTable.getRowCount(); rowNumber++) {
                        TableCellRenderer cellRenderer = productsTable.getCellRenderer(rowNumber, columnNumber);
                        Component cell = productsTable.prepareRenderer(cellRenderer, rowNumber, columnNumber);
                        columnWidth = Math.max(columnWidth, cell.getPreferredSize().width + 1);
                    }
                    columnWidth = Math.min(MAX_COLUMN_WIDTH, columnWidth);
                    accumulativeColumnsWidth += columnWidth;
                }
                else
                {
                    columnWidth = productsTable.getParent().getParent().getPreferredSize().width - accumulativeColumnsWidth;
                }
                productsTable.getColumnModel().getColumn(columnNumber).setPreferredWidth(columnWidth);
            }
        }
    }
}
