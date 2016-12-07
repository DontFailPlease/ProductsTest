package view.products.product.view;

import com.sun.tools.javac.util.Convert;
import custom.components.ImagePanel;
import dao.model.Product;
import view.products.list.Products;
import view.products.list.ProductsTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Refactor this class.
 */
public class ProductEditor extends JPanel implements ProductEditorInterface{
    private File imageFile;

    private Products productsObject;

    private ImagePanel picturePanel;
    private JTextField productNameTextField;
    private JFormattedTextField priceTextField;
    private JTextArea descriptionTextArea;
    private JLabel panelNameLabel;
    private JButton addImageButton;
    private JButton saveButton;
    private JButton cancelButton;

    public ProductEditor()
    {
        generateGUI();
    }

    private JLabel getPanelNameLabel()
    {
        if(panelNameLabel == null) {
            panelNameLabel = new JLabel("");
            panelNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        }
        return panelNameLabel;
    }


    public Products getProductsObject() {
        return productsObject;
    }

    public void setProductsObject(Products productsObject) {
        this.productsObject = productsObject;
    }


    private JTextField getProductNametextField() {
        if (productNameTextField == null) {
            productNameTextField = new JTextField();
            productNameTextField.setPreferredSize(new Dimension(100, productNameTextField.getPreferredSize().height));
        }
        return productNameTextField;
    }

    private JFormattedTextField getPriceTextField()
    {
        if(priceTextField == null) {
            priceTextField = new JFormattedTextField();
        }
        return priceTextField;
    }

    private ImagePanel getPicturePanel() {
        if(picturePanel == null) {
            picturePanel = new ImagePanel(imageFile);
            picturePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            picturePanel.setPreferredSize(new Dimension(150, 150));
        }
        return picturePanel;
    }

    private JButton getAddImageButton() {
        if(addImageButton == null) {

            addImageButton = new JButton("add image");
            addImageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser imageFileChooser = new JFileChooser();
                    int returnValue = imageFileChooser.showOpenDialog(ProductEditor.this);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        imageFile = imageFileChooser.getSelectedFile();
                        picturePanel.setImage(imageFile);
                        picturePanel.repaint();
                    }
                }
            });
        }
        return addImageButton;
    }

    private JButton getSaveButton()
    {
        if(saveButton == null) {
            saveButton = new JButton("save");
            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JTable productsTable = getProductsObject().getProductsTable();
                    ProductsTableModel model = ((ProductsTableModel)productsTable.getModel());

                    String productName = getProductNametextField().getText();
                    int price = Integer.parseInt(getPriceTextField().getText());
                    File filePath = getPicturePanel().getImage();
                    String description = getDescriptionTextArea().getText();
                    int selectedRowInTable = productsTable.getSelectedRow();

                    if(selectedRowInTable < 0)
                    {
                        // add row
                        model.addProduct(productName, price, filePath, description);
                    } else{
                        // edit row
                        int selectedRowInModel = productsTable.convertRowIndexToModel(selectedRowInTable);
                        Product selectedProduct = model.getProduct(selectedRowInModel);
                        model.updateProduct(selectedProduct, productName, price, filePath, description);
                    }
                }
            });
        }
        return saveButton;
    }

    private JButton getCancelButton()
    {
        if(cancelButton == null)
        {
            cancelButton = new JButton("cancel");
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    System.out.println("cancel");
                }
            });
        }
        return cancelButton;
    }

    private JTextArea getDescriptionTextArea() {
        if(descriptionTextArea == null) {
            descriptionTextArea = new JTextArea();
        }
        return descriptionTextArea;
    }

    private void generateGUI() {
        packLayout();
    }

    private void packLayout() {
        this.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridwidth = 3;
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.anchor = GridBagConstraints.PAGE_START;
        constraints.ipady = 30;
        this.add(getPanelNameLabel(), constraints);

        constraints.gridwidth = 1;
        constraints.gridy = 1;
        constraints.gridx = 0;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.ipadx = 10;
        constraints.ipady = 0;

        JLabel productNameLabel = new JLabel("product name:");
        this.add(productNameLabel, constraints);
        constraints.gridx ++;
        this.add(getProductNametextField(), constraints);

        constraints.gridy ++;
        constraints.gridx = 0;
        JLabel priceLabel = new JLabel("price:");
        this.add(priceLabel, constraints);
        constraints.gridx ++;
        this.add(getPriceTextField(), constraints);

        constraints.gridy ++;
        constraints.gridx = 0;
        JLabel imageLabel = new JLabel("image:");
        this.add(imageLabel, constraints);
        constraints.gridy = 2;
        constraints.gridx = 2;
        constraints.gridheight = 2;
        constraints.insets = new Insets(0, 45, 0, 0);
        this.add(getPicturePanel(), constraints);

        constraints.gridy = 3;
        constraints.gridx = 1;
        constraints.gridheight = 1;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(getAddImageButton(), constraints);

        constraints.gridy ++;
        constraints.gridx = 0;
        JLabel descriptionLabel = new JLabel("product description:");
        this.add(descriptionLabel, constraints);

        constraints.gridx ++;
        constraints.gridwidth = 2;
        constraints.ipady = 50;

        this.add(getDescriptionTextArea(), constraints);

        JToolBar buttonsBar = new JToolBar(JToolBar.HORIZONTAL);
        constraints.gridy ++;
        constraints.gridx = 0;
        constraints.gridwidth = 3;
        constraints.ipady = 5;
        constraints.anchor = GridBagConstraints.PAGE_END;
        buttonsBar.add(Box.createHorizontalGlue());
        buttonsBar.setBorderPainted(false);

        buttonsBar.add(getCancelButton());
        buttonsBar.addSeparator(new Dimension(buttonsBar.getPreferredSize().height, 20));
        buttonsBar.add(getSaveButton());
        this.add(buttonsBar, constraints);
    }

    @Override
    public void setPanelName(String name) {
        this.getPanelNameLabel().setText(name);
    }

    @Override
    public void setName(String name) {
        this.getProductNametextField().setText(name);
    }

    @Override
    public void setPrice(Integer price) {
        this.priceTextField.setText(String.valueOf(price));
    }

    @Override
    public void setImage(File image) {
        this.getPicturePanel().setImage(image);
    }

    @Override
    public void setDescription(String description) {
        this.getDescriptionTextArea().setText(description);
    }
}
