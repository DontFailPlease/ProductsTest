package view.products.product.builder;

import view.products.product.view.ProductEditor;

/**
 * Created by di on 07.12.16.
 */
public abstract class ProductEditorBuilder {

    protected ProductEditor productEditor;

    public ProductEditor getProductEditor() {
        return productEditor;
    }

    public void createProductEditor() {
        if (productEditor == null) {
            productEditor = ProductEditorSingle.getProductEditor();
        }
    }

    public abstract void buildPanelName();
    public abstract void buildName();
    public abstract void buildPrice();
    public abstract void buildImage();
    public abstract void buildDescription();
}
