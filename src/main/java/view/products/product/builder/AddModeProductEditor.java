package view.products.product.builder;

/**
 * Created by di on 07.12.16.
 */
public class AddModeProductEditor extends ProductEditorBuilder {

    private final String PANEL_TEXT = "Add new product.";

    @Override
    public void buildPanelName() {
        productEditor.setPanelName(PANEL_TEXT);
    }

    @Override
    public void buildName() {
        productEditor.setName(null);
    }

    @Override
    public void buildPrice() {
        productEditor.setPrice(0);
    }

    @Override
    public void buildImage() {
        productEditor.setImage(null);
    }

    @Override
    public void buildDescription() {
        productEditor.setDescription(null);
    }
}
