package view.products.product.builder;

/**
 * Created by di on 07.12.16.
 */
public class Waiter {

    private ProductEditorBuilder builder;

    public void setBuilder(ProductEditorBuilder builder) {
        this.builder = builder;
    }

    public void constructProductEditor()
    {
        builder.createProductEditor();
        builder.buildPanelName();
        builder.buildName();
        builder.buildPrice();
        builder.buildImage();
        builder.buildDescription();
    }
}
