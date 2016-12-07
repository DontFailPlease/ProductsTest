package view.products.product.builder;

import dao.model.Product;

/**
 * Created by di on 07.12.16.
 */
public class EditModeProductEditor extends ProductEditorBuilder {

    Product selectedProduct;
    public EditModeProductEditor(Product selectedProduct)
    {
        this.selectedProduct = selectedProduct;
    }

    @Override
    public void buildName() {
        productEditor.setName(selectedProduct.getName());
    }
}
