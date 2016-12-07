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
        productEditor = ProductEditorSingle.getProductEditor();
    }

    public abstract void buildName();

}
