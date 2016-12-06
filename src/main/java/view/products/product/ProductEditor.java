package view.products.product;

import custom.components.ImagePanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

/**
 * Refactor this class.
 */
public class ProductEditor extends JPanel {
    OpeningMode windowMode;
    File imageFile;
    ImagePanel picturePanel;

    public ProductEditor(OpeningMode openWindowMode)
    {
        this.windowMode = openWindowMode;
        generateGUI();
    }

    private String getPanelName()
    {
        switch(windowMode)
        {
            case ADD_MODE:
                return "Add new product.";
            case EDIT_MODE:
                return "Edit product.";
            default:
                return null;
        }
    }


    private void generateGUI()
    {
        this.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridwidth = 3;
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.anchor = GridBagConstraints.PAGE_START;
        constraints.ipady = 30;

        JLabel panelNameLabel = new JLabel(getPanelName());
        panelNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        this.add(panelNameLabel, constraints);

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

        constraints.gridy = 1;
        constraints.gridx = 1;

        JTextField productNameTextField = new JTextField();
        productNameTextField.setPreferredSize(new Dimension(100, productNameTextField.getPreferredSize().height));
        this.add(productNameTextField, constraints);

        constraints.gridy = 2;
        constraints.gridx = 0;

        JLabel priceLabel = new JLabel("price:");
        this.add(priceLabel, constraints);

        constraints.gridy = 2;
        constraints.gridx = 1;

        JFormattedTextField priceTextField = new JFormattedTextField();
        this.add(priceTextField, constraints);

        constraints.gridy = 3;
        constraints.gridx = 0;

        JLabel imageLabel = new JLabel("image:");
        this.add(imageLabel, constraints);

        constraints.gridy = 3;
        constraints.gridx = 2;

        picturePanel = new ImagePanel(imageFile);
        picturePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        picturePanel.setPreferredSize(new Dimension(100, 100));

        this.add(picturePanel, constraints);

        constraints.gridy = 3;
        constraints.gridx = 1;
        constraints.insets = new Insets(0, 0, 0, 45);

        JButton addImageButton = new JButton("add image");
        addImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser imageFileChooser = new JFileChooser();
                int returnValue = imageFileChooser.showOpenDialog(ProductEditor.this);
                if(returnValue == JFileChooser.APPROVE_OPTION)
                {
                    imageFile = imageFileChooser.getSelectedFile();
                    picturePanel.setImage(imageFile);
                    picturePanel.repaint();
                }
            }
        });
        this.add(addImageButton, constraints);

        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.gridy = 4;
        constraints.gridx = 0;

        JLabel descriptionLabel = new JLabel("product description:");
        this.add(descriptionLabel, constraints);

        constraints.gridy = 4;
        constraints.gridx = 1;
        constraints.gridwidth = 2;
        constraints.ipady = 50;

        JTextArea descriptionTextArea = new JTextArea();
        this.add(descriptionTextArea, constraints);

    }

    private void packRow(Component...componentsInRow)
    {

    }
}
