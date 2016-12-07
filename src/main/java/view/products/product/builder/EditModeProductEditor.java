package view.products.product.builder;

import dao.model.Product;

/**
 * Created by di on 07.12.16.
 */
public class EditModeProductEditor extends ProductEditorBuilder {

    private final String PANEL_TEXT = "Edit product.";
    private Product selectedProduct;

    public EditModeProductEditor(Product selectedProduct)
    {
        this.selectedProduct = selectedProduct;
    }

    @Override
    public void buildPanelName() {
        productEditor.setPanelName(PANEL_TEXT);
    }

    @Override
    public void buildName() {
        productEditor.setName(selectedProduct.getName());
    }

    @Override
    public void buildPrice() {
        productEditor.setPrice(selectedProduct.getPriсe());
    }

    @Override
    public void buildImage() {
        productEditor.setImage(selectedProduct.getImage());
    }

    @Override
    public void buildDescription() {
        productEditor.setDescription(selectedProduct.getDescription());
    }
}
