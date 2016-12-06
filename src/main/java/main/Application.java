package main;

import view.main.Main;
import view.products.list.Products;
import view.products.product.OpeningMode;
import view.products.product.ProductEditor;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;

/**
 * Created by di on 29.11.16.
 */
public class Application extends JApplet {
    private JSplitPane splitPane;
    private final int DIVIDER_SIZE = 2;

    public void init()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize( screenSize.width / 3 * 2, screenSize.height / 3);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    initGuiConfigurations();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initGuiConfigurations() throws Exception {
        Main mainView = new Main();
        Products productsPane = new Products();
        ProductEditor productEditorView = new ProductEditor(OpeningMode.ADD_MODE);

        JSplitPane innerSplitPane = createSplitPane();
        innerSplitPane.setLeftComponent(productsPane);
        innerSplitPane.setRightComponent(productEditorView);
        innerSplitPane.setDividerLocation(productsPane.getPreferredSize().width);

        splitPane = createSplitPane();
        splitPane.setLeftComponent(mainView);
        splitPane.setRightComponent(innerSplitPane);
        splitPane.setDividerLocation(mainView.getPreferredSize().width);

        getContentPane().add(splitPane);
    }

    private JSplitPane createSplitPane()
    {
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerSize(DIVIDER_SIZE);

        splitPane.setUI(new BasicSplitPaneUI() {
            public BasicSplitPaneDivider createDefaultDivider() {
                return new BasicSplitPaneDivider(this) {
                    public void setBorder(Border b) {
                    }

                    @Override
                    public void paint(Graphics g) {

                        g.setColor(Color.lightGray);
                        g.fillRect(0, 0, getSize().width, getSize().height);
                        super.paint(g);
                    }
                };
            }
        });
        splitPane.setBorder(null);

        return splitPane;
    }

}
