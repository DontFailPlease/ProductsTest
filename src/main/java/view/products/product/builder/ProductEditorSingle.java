package view.products.product.builder;

import view.products.product.view.ProductEditor;

/**
 * Created by di on 07.12.16.
 */
public class ProductEditorSingle {
    private static ProductEditor productEditor = null;

    public static ProductEditor getProductEditor()
    {
        if(productEditor == null) {
           productEditor = new ProductEditor();
        }
        return productEditor;
    }
}
