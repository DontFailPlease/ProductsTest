package view.main;

import view.products.product.OpeningMode;
import view.products.product.ProductEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by di on 29.11.16.
 */
public class Main extends JApplet {

    public Main()
    {
        generateGUI();
    }

    private void generateGUI()
    {
        JButton addButton = new JButton("Add product");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new ProductEditor(OpeningMode.ADD_MODE);
            }
        });

        JButton editButton = new JButton("Edit product");
        JButton deleteButton = new JButton("Delete product");

        addComponents(addButton, editButton, deleteButton);
    }

    private void addComponents(JComponent ... comp)
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();

        for(JComponent currentComponent : comp)
        {
            currentComponent.setAlignmentY(Component.CENTER_ALIGNMENT);
            grid.gridy = grid.gridy + 1;
            grid.fill = GridBagConstraints.HORIZONTAL;
            panel.add(currentComponent, grid);
        }
        this.getContentPane().add(panel, BorderLayout.CENTER);
    }
}
